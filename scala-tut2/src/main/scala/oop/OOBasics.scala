package oop

import javax.crypto.spec.PBEParameterSpec

object OOBasics extends App{

    val person = new Person("John", 26)
    println(person.age)
    println(person.x)
    person.greet("Daniel")
}
/*
Classes
Parameters
Fields
Constructors
Overloading
*/
// constructor
// Everytime class instantiation is done, the entire class is executed
class Person(name: String, val age: Int) {

  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  //Overloading
  def greet(): Unit = println(s"Hi, I am $name")
  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

}
/*
Novel and a Writer
Writer: firstname, surname, year
  - method full name
Novel: name, year of release, author
  - author age
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
*/

class Writer(firstName: String, surname: String, val year: Int){
  def fullName: String = firstName + " " + surname
}
class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


/*
  Counter Class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count: Int) {
  def inc = new Counter(count + 1) // immutability: you can't change the contents of instances
                          // you need to instatiate the instance again
  def dec = new Counter(count - 1)


}
// Class parameters are NOT FIELDS