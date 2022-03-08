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

  class ShapesTest:
    import org.junit.Assert.assertEquals
    import org.junit.Test
    import Es7.Shape
    import Es7.Shape.{Circle, Rectangle, Square}
    import Es7.Shape.{area, perimeter}
    import scala.math.Pi
    import scala.math.pow
  
    val radius: Int = 5
    val base: Int = 2
    val height: Int = 3
    val side: Int = 4
  
    val rectangle: Shape = Rectangle(base, height)
    val circle: Shape = Circle(radius)
    val square: Shape = Square(side)
  
    @Test def testRectanglePerimeter(): Unit =
      assertEquals(perimeter(rectangle), (base + height) * 2, 0)
  
    @Test def testCirclePerimeter(): Unit =
      assertEquals(perimeter(circle), 2 * radius * Pi, 0)
  
    @Test def testSquarePerimeter(): Unit =
      assertEquals(perimeter(square), 4 * side, 0)
  
    @Test def testRectangleArea(): Unit =
      assertEquals(area(rectangle), base * height, 0)
  
    @Test def testCircleArea(): Unit =
      assertEquals(area(circle), pow(radius, 2) * Pi, 0)
  
    @Test def testSquareArea(): Unit =
      assertEquals(area(square), pow(side, 2), 0)
