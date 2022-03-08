package exercises

import org.junit.Assert.*
import org.junit.Test

// --- 3c ---
class Es3Test:

  def neg[A](p: A => Boolean): A => Boolean = (x: A) => !p(x)
  val empty: String => Boolean = _ == ""
  val notEmpty: String => Boolean = neg(empty)

  @Test def testNegationWhenEmpty(): Unit =
    assertFalse(notEmpty(""))

  @Test def testNegationWhenNotEmpty(): Unit =
    assertTrue(notEmpty("foo"))

  @Test def testNegationWithBothCases(): Unit =
    assertTrue(notEmpty("foo") && !notEmpty(""))
