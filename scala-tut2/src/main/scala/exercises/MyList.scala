package exercises

abstract class MyList[+A] {




  /*
    Method head will return the list which is the first element (takes list, returns address ?)
    Method Tail will return reminder of the list (takes a list returns remonder)
    isEmpty - Boolean (takes list, returns boolean)
    add(int) - new list with this element added, takes integer returns list
    toString - a string representation of the list -
    decide on method signature first
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "|" + printElements + "|"
}

object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) h.toString
    else h.toString + " " + t.printElements
}

object ListTest extends App{
  val listOfIntergers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntergers.toString)
  println(listOfStrings.toString)
}