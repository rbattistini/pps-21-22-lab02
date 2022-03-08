package exercises

object Es6 extends App:

  def fibonacci(n: Int): Int =
    @annotation.tailrec
    def _fib(n: Int, a: Int, b: Int): Int = n match
      case 0 => a
      case 1 => b
      case _ => _fib(n - 1, b, a + b)
  
    _fib(n, 0, 1)
  
  fibonacci(0)
  fibonacci(1)
  fibonacci(2)
  fibonacci(3)
  fibonacci(4)