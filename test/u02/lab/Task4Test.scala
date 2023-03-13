package u02.lab

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue, assertFalse}
import u02.lab.Task4.Shape.{Circle, Rectangle, Square, contains, perimeter}

class Task4Test:

  @Test def testSquarePerimeter(): Unit =
    assertEquals(16.0, perimeter(Square(4.0)))

  @Test def testCirclePerimeter(): Unit =
    assertEquals(Math.PI, perimeter(Circle(0.5))) // FuzzyEquals ?

  @Test def testRectanglePerimeter(): Unit =
    assertEquals(6.0, perimeter(Rectangle(1.0, 2.0)))

  @Test def testCircleContains(): Unit =
    assertTrue(contains(Circle(1.0), (0.2, 0.4)))
    assertFalse(contains(Circle(1.0), (2.0, 1.5)))

  @Test def testRectangleContains(): Unit =
    assertTrue(contains(Rectangle(2.0, 5.0), (1.3, 4.0)))
    assertFalse(contains(Rectangle(2.0, 5.0), (4.0, 5.0)))

  @Test def testSquareContains(): Unit =
    assertTrue(contains(Square(2.0), (1.0, 1.5)))
    assertFalse(contains(Square(2.0), (1.0, 3.5)))



