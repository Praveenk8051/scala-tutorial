package lectures

object Expressions extends App {
  val x = 1+2
  println(x) // +,-,/,|, >>. <<, >>> (right shift with zero extension)
  // ==, !=, >, >=, <=
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  // side effects: println(), whiles, reassigning
  val aCodeBlock = {
    val y = 2
    val z = y+1

    if ( z > 2) "hello" else "good" // aCodeBlock is of type string because the return value is string,
    // the value cannot be accessed outside aCodeBlock
  }
  // Difference between "Hello World" and println("hello world")? first is string and 2nd is evaluated expressions which is a side effect,
  // second one is type Unit, first one type string
  val someValue = {
    2 < 3
  }// returns boolean
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }// return int

}
