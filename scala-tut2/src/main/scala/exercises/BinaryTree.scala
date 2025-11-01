package exercises

abstract class BinaryTree {
  def incl(x: Int): BinaryTree
  def contains(x: Int): Boolean
  def union(s: BinaryTree): BinaryTree
}

class Empty2 extends BinaryTree {
  def contains(x: Int) = false
  def incl(x: Int): BinaryTree = NonEmpty(x, Empty2(), Empty2())
  def union(s: BinaryTree): BinaryTree = s
}

class NonEmpty(elem: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree {
  def contains(x: Int): Boolean = {
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true
  }

  def incl(x: Int): BinaryTree = {
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this
  }

  def union(s: BinaryTree): BinaryTree =
    left.union(right).union(s).incl(elem)

}

object Execute extends App{
  val t1 = Empty2()
  val t2 = t1.incl(3)
  val t3 = t2.incl(5)
  println(t3)
}