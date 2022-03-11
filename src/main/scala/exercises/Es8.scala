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
      case Some(a) => Some(p(a))
      case _ => None()

    def map2[A](optA: Option[A], optB: Option[A])(f: (A, A) => A): Option[A] = (optA, optB) match
      case (Some(a), Some(b)) => Some(f(a, b))
      case (_, _) => None()
