package oop

object MethodNotations extends App{

    class Person(val name: String, favoriteMovie: String){

        def likes(movie: String): Boolean = movie == favoriteMovie
        def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
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
        
     */


}
