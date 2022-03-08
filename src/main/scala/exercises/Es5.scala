package exercises

object Es5 extends App:
  
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))
  
  compose(_ - 1, _ * 2)(5)

  def composeGeneric[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  composeGeneric[Int, Int, Double](_ - 1.2, _ / 2)(5)