package u02.lab.delivery

import scala.annotation.tailrec

object LabDelivery extends App:
  // TASK 2a
  val positive: Int => String = x => x match
    case x if x >= 0 => "positive"
    case _ => "negative"
  def positiveMethod(x: Int): String = positive(x)

  val neg: (String => Boolean) => String => Boolean = predicate => !predicate(_)
  def negMethod[T](predicate: T => Boolean): T => Boolean = !predicate(_)

  // -------------TEST-----------------
  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)

  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true
  // ----------------------------------

  // TASK 2b
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => p1(x)(y)(z)
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = p3(x)(y)(z)

  def compose(f: Int => Int, g: Int => Int): Int => Int = n => f(g(n))
  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = e => f(g(e))

  // -------------TEST-----------------
  println(compose(_ - 1, _ * 2)(5)) // 9
  println(genericCompose((x: String) => x.length, x => s"$x")(234)) // 3
  // ----------------------------------

  // TASK 3
  @tailrec
  def gcd(a: Int, b: Int): Int = b match
    case 0 => a
    case _ => gcd(b, a % b)

  // -------------TEST-----------------
  println(gcd(12, 8)) // 4
  println(gcd(14, 7)) // 7
  // ----------------------------------

  // TASK 4
  enum Shape:
    case Rectangle(x: Double, y: Double)
    case Circle(r: Double)
    case Square(l: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Circle(r) => 2 * Math.PI * r
      case Square(l) => l * l
      case Rectangle(x, y) => 2 * (x + y)

    private def inRange(a: Double)(x: Double)(b: Double) = a <= x && x <= b

    def contains(shape: Shape, point: (Double, Double)): Boolean = (shape, point) match
      case (Circle(r), (x, y)) => Math.sqrt(x * x + y + y) < r // center is in (0,0)
      case (Rectangle(w, h), (x, y)) => inRange(0)(x)(w) && inRange(0)(y)(h) // bottom-left is in (0, 0)
      case (Square(l), (x, y)) => inRange(0)(x)(l) && inRange(0)(y)(l) // bottom-left is in (0, 0)

  // Tests are on https://github.com/kelvin-olaiya/pps-22-23-lab02/blob/chore/delivery/test/u02/lab/Task4Test.scala

  // TASK 5
  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:
    def filter[A](opt: Option[A])(p: A => Boolean): Option[A] = opt match
      case Some(a) if p(a) => opt
      case _ => None[A]()

    def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt match
      case Some(a) => Some(f(a))
      case _ => None[B]()

    def fold[A](opt: Option[A])(n: A)(f: A => A): A = opt match
      case Some(a) => f(a)
      case _ => n

  import Option.*

  // -------------TEST-----------------
  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  println(filter(Some(5))(_ > 2)) // Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  println(map(Some(5))(_ > 2)) // Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None

  println(fold(Some(5))(1)(_ + 1)) // 6
  println(fold(None[Int]())(1)(_ + 1)) // 1
  // ----------------------------------
