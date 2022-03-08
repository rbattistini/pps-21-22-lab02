package exercises

object Es4 extends App:

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y <= z
  val part1 = p1(1)(2)
  part1(3)
  part1(1)
  
  val p2 = (x: Int, y: Int, z: Int) => x <= y && y <= z
  p2(1, 2, 3)
  p2(3, 2, 1)
  
  def p3(x: Int)(y: Int )(z: Int): Boolean = x <= y && y <= z
  val part2 = p3(1)(2)
  part2(3)
  part2(1)
  
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y <= z
  p4(1, 2, 3)
  p4(3, 2, 1)