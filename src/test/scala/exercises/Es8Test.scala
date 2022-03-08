package exercises

import Es8.Option
import Es8.Option.*
import org.junit.Assert.*
import org.junit.Test

  class Es8Test:
    val s1: Option[Int] = Some(1)
    val s2: Option[Int] = Some(2)
    val s3: Option[Int] = None()

    @Test def testNonEmptyOptional(): Unit =
      assertFalse(isEmpty(s1))

    @Test def testEmptyOptional(): Unit =
      assertTrue(isEmpty(s3))

    @Test def testOrElseNonEmpty(): Unit =
      assertEquals(orElse(s3, 1), 1)

    @Test def testOrElseEmpty(): Unit =
      assertEquals(orElse(s1, 0), 1)

    @Test def testFlatMapNonEmpty(): Unit =
      assertEquals(flatMap(s1)(i => flatMap(s2)(j => Some(i + j))), Some(3))

    @Test def testFlatMapEmpty(): Unit =
      assertEquals(flatMap(s3)(j => Some(j * 2)), None())

    @Test def testFilterNonEmptyMatched(): Unit =
      assertEquals(filter(s2)(_ >= 2), s2)

    @Test def testFilterNonEmptyNonMatched(): Unit =
      assertEquals(filter(s1)(_ >= 2), None())

    @Test def testFilterEmpty(): Unit =
      assertEquals(filter(s1)(_ > 8), None())

    @Test def testMapNonEmptyMatched(): Unit =
      assertEquals(map(s2)(_ >= 2), Some(true))

    @Test def testMapNonEmptyNonMatched(): Unit =
      assertEquals(map(s1)(_ >= 2), Some(false))

    @Test def testMapEmpty(): Unit =
      assertEquals(map(s3)(_ > 8), None())

    @Test def testMap2NonEmptyMatched(): Unit =
      assertEquals(map2(s1, s2)(_ + _), Some(1 + 2))

    @Test def testMap2NonEmptyNonMatched(): Unit =
      assertEquals(map2(s1, s3)(_ + _), None())

    @Test def testMap2Empty(): Unit =
      assertEquals(map2(s3, s3)(_ + _), None())

    @Test def testInvertBooleanOpt(): Unit =
      assertEquals(map(s1)(_ >= 0), Some(true))

    @Test def testDoubleOptionalContent(): Unit =
      assertEquals(flatMap(s2)(j => Some(j * 2)), Some(4))
