package u02.lab

object Task2b extends App:
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => p1(x)(y)(z)

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = p3(x)(y)(z)

  def compose(f: Int => Int, g: Int => Int): Int => Int = n => f(g(n))
  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = e => f(g(e))

  // Test
  println(compose(_ - 1, _ * 2)(5))
  println(genericCompose((x: String) => x.length, x => s"$x")(234))

