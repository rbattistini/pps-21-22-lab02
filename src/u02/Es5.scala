def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

compose(_ - 1, _ * 2)(5)

def composeGeneric[A](f: A => A, g: A => A): A => A = (x: A) => f(g(x))

composeGeneric[Double](_ - 1.1, _ * 2.2)(5.1)