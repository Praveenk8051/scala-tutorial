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
  // B >: A is done to handle the covariance of MyList
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "|" + printElements + "|"

  // Higher Order Functions : Receives Func a params or returns Func
  def map[B](transformer: A => B): MyList[B]
  def flatmap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatmap[B](transformer: Nothing =>MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) h.toString
    else h.toString + " " + t.printElements

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer.apply(h), t.map(transformer))


  def flatmap[B](transformer: A => MyList[B]): MyList[B] =
    transformer.apply(h) ++ t.flatmap(transformer)

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}




object ListTest extends App{
  val listOfIntergers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntergers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntergers.toString)
  println(listOfStrings.toString)
  println(listOfIntergers.map(elem => elem * 2).toString)
  // println(listOfIntergers.map(_ * 2).toString)
  println(listOfIntergers.filter(elem => elem % 2 == 0).toString)

  println((listOfIntergers ++ anotherListOfIntergers).toString)
  println(listOfIntergers.flatmap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)
}
/*
1. Create a generic trait called MyPredicate[-T], this will have method whether a parameter of type T passes a condition.
Every subclass of MyPredicate[T] will have different implementation it tests whether T passes that condition
Method called test(T) => Boolean

2. Generic Trait MyTransformer[-A, B] - Convert from Type A to Type B, every subclass will different implementation of
that method
with a method transform(A) => B
3. MyList:
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]
   class EvenPredicate extends MyPredicate[Int]
   class StringToIntTransformer extends MyTransformer[String, Int]

  [1,2,3].map(n*2) = [2,4,6]
  [1,2,3,4].filter(n % 2) = [2,4]
  [1,2,3].flatmap(n => [n,n+1]) => [1,2,2,3,3,4]
*/