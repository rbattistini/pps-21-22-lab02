package exercises

object BinaryTrees:

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

  class BinaryTreeTest:
    import Tree.*
    import org.junit.Assert.*
    import org.junit.Test
  
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(1))
  
    @Test def testCount(): Unit =
      assertEquals(2, count(tree, 1))
      assertEquals(1, count(tree, 2))
      assertEquals(0, count(tree, 3))
  
    @Test def testSize(): Unit =
      assertEquals(3, size(tree))
  
    @Test def testFind(): Unit =
      assertTrue(find(tree, 2))
      assertFalse(find(tree, 4))
