package u02.lab

object Task3 extends App:

  def gcd(a: Int, b: Int): Int = b match
    case 0 => a
    case _ => gcd(b, a % b)

  // Test
  println(gcd(12, 8)) // 4
  println(gcd(14, 7)) // 7
