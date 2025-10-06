package lectures

import scala.annotation.tailrec

object Recursions extends App {
  def factorial(n: Int): Int =
    if (n<=1) 1
    else n * factorial(n-1)

  // Concatenate Strings
 // def joinStrings(num: Int, str: String): String = {
  @tailrec
  def helpConcatenate(x: Int, str: String, accumulator: String): String =
    if (x<=0) accumulator
    else helpConcatenate(x-1, str, str + accumulator)

  println(helpConcatenate(3, "something", ""))

  // 4. Tests if number is prime
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  // IsPrime function
  // Fibonacci
  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
