package exercises

object Es7 extends App:
  import scala.math.{Pi, pow}

  enum Shape:
    case Rectangle(b: Double, h: Double)
    case Circle(r: Double)
    case Square(s: Double)

  object Shape:
    def perimeter(shape: Shape) : Double = shape match
      case Rectangle(b, h) => 2 * (b + h)
      case Circle(r) => 2 * Pi * r
      case Square(s) => 4 * s

    def area(shape: Shape): Double = shape match
      case Rectangle(l, h) => l * h
      case Circle(r) => pow(r, 2) * Pi
      case Square(s) => pow(s, 2)
