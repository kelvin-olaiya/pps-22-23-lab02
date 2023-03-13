package u02.lab

object Task2a extends App {

  val positive: Int => String = x => x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  def positiveMethod(x: Int): String = positive(x)

  val neg: (String => Boolean) => String => Boolean = predicate => !predicate(_)
  def negMethod[T](predicate: T => Boolean): T => Boolean = !predicate(_)

  // TEST?
  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))
}
