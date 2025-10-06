package lectures

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  // 1. A greeting function,
  def aGreetingFunction(x: String, y: Int): String = {
    "Hi, my name is " + x + " and I am " + y + "and I am years old"
  }

  println(aGreetingFunction("Max", 20))

  // 2. Factorial Function , calculate the product of the number
  def aFactorialFunction(x: Int): Int = {
    if (x <= 0) 1
    else x * aFactorialFunction(x - 1)
  }

  println(aFactorialFunction(3))

  // 3. Fibonacci number
  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(4))

}
// In functional programming we use recursion instead of loops