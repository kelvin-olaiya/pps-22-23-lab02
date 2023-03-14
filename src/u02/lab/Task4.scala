package u02.lab

object Task4 extends App:
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
      case (Circle(r), (x, y)) => Math.sqrt(x*x + y+y) < r
      case (Rectangle(w, h), (x, y)) => inRange(0)(x)(w) && inRange(0)(y)(h)
      case (Square(l), (x, y)) => inRange(0)(x)(l) && inRange(0)(y)(l)
