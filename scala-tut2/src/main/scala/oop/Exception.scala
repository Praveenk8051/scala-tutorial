package oop

object Exception extends App{

  /*
  1. Crash your program with an OOM
  2. Crash with SOError
  2. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */
    object someOOM(elem: Int): Int
      elem * (elem - 1)

    println(someOOM(5))

    object someStackOverFlow(AnotherElem: Int): Int
  AnotherElem
}
