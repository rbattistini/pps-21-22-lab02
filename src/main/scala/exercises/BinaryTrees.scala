package exercises

object BinaryTrees extends App:

  enum Tree[A]:
    case Leaf(value: A)
    case Branch(left: Tree[A], right: Tree[A])

  object Tree:
    def fold[A, B](t: Tree[A])(map: A => B)(red: (B, B) => B): B = t match
      case Branch(l, r) => red(fold(l)(map)(red), fold(r)(map)(red))
      case Leaf(e) => map(e)

    def size[A](t: Tree[A]): Int =
      fold(t)(x => 1)(_ + _)

    def find[A](t: Tree[A], elem: A): Boolean =
      fold(t)(e => e == elem)(_ || _)

    def count[A](t: Tree[A], elem: A): Int =
      fold(t)(x => if x == elem then 1 else 0)(_ + _)
