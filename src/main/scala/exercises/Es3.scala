package exercises

object Es3 extends App:
  // --- 3a ---
  val isEvenLambda: Int => String = (i: Int) => if (i % 2 == 0) "even" else "odd"
  
  isEvenLambda(2)
  isEvenLambda(3)
  
  def isEven(i: Int): String = if (i % 2 == 0) "even" else "odd"
  
  isEven(2)
  isEven(3)
  
  
  // --- 3b ---
  val empty: String => Boolean = _ == ""
  def neg(p: String => Boolean): String => Boolean = (x: String) => !p(x)
  val notEmpty = neg(empty)
  
  notEmpty("foo")
  notEmpty("")
  
  val negLambda = (p: String => Boolean) => (x: String) => !p(x)
  val notEmptyLambda = negLambda(empty)
  
  notEmptyLambda("foo")
