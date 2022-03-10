package exercises

object Es3 extends App:
  // --- 3a ---
  val isEvenLambda: Int => String = i => i match
    case i if i % 2 == 0 => "even"
    case _ => "odd"
  
  isEvenLambda(2)
  isEvenLambda(3)
  
  def isEven(i: Int): String = i match
    case i if i % 2 == 0 => "even"
    case _ => "odd"
  
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
