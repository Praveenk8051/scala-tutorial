package exercises

abstract class MyList {




  /*
    Method head will return the list which is the first element (takes list, returns address ?)
    Method Tail will return reminder of the list (takes a list returns remonder)
    isEmpty - Boolean (takes list, returns boolean)
    add(int) - new list with this element added, takes integer returns list
    toString - a string representation of the list -
    decide on method signature first
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "|" + printElements + "|"
}

object Empty extends MyList{
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String = 
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App{
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  
  println(list.toString)
}