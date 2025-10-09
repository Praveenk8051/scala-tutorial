package oop

object MethodNotations extends App{

    class Person(val name: String, favoriteMovie: String){

        def likes(movie: String): Boolean = movie == favoriteMovie
        def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def +(nickName: String): Person = new Person(s"${this.name} ($nickName)", favoriteMovie)
        def unary_+ : Person = new Person(name, favoriteMovie) // new person with age incremented
        def learns(subject: String): String = s"$name learns $subject"
        def learnsScala: String = this learns "Scala"
        def apply(times: Int): String = s"$name watched $favoriteMovie $times times"
        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary likes("Inception")) 
    /* 
    infix notation = operator notation (syntactic sugar) - 
    only works with methods that have a single parameter
     */
    val tom = new Person("Tom", "Fight Club")
    println(mary.hangOutWith(tom))
    println(mary hangOutWith tom)
    /* 
    Method names can symbolic like (+, &, etc).
    Infix notation works with those too
     */
    // ALL OPERATORS ARE METHODS
    println(1 + 2)
    println(1.+(2))
    //prefer  notation another form of syntactic sugar
    val x = -10
    val y = 1.unary_-

    // post-fix notation, may give ambiguous code
    // apply-Method - special method, no parameters
    /*
        1. Overload the + operator
            mary + "the rockstar" => new person "Mary (the rockstar)"
        2. Add an age to the Person class
            Add a unary + operator => new person with the age + 1
            +mary => mary with the age incrementer
        3. Add a "learns" method in the person class => "Mary learns Scala"
            Add a learnsScala method, calls learns method with "Scala"
            Use it in postfix notation
        4. Overload the apply method
            mary.apply(2) => "Mary watched Inception 2 times"
     */


}
