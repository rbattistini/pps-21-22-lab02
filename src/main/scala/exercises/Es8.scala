package exercises

object Es8 extends App:

  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:
    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(p: A => Boolean): Option[A] = opt match
      case Some(a) if p(a) => Some(a)
      case _ => None()

    def map[A](opt: Option[A])(p: A => Boolean): Option[Boolean] = opt match
      case Some(a) if p(a) => Some(true)
      case Some(a) if !p(a) => Some(false)
      case _ => None()

    def map2[A](optA: Option[A], optB: Option[A])(f: (A, A) => A): Option[A] = (optA, optB) match
      case (Some(a), Some(b)) if !isEmpty(optA) && !isEmpty(optB) => Some(f(a, b))
      case (_, _) => None()

  class OptionalsExtTest:
    import Option.*
    import org.junit.Assert.*
    import org.junit.Test
    
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
