package oop

object Objects extends App{

    object Person{ // type + its only instance
        val N_EYES = 2
        def canFly: Boolean = false
    }
    class Person(val name: String){

    }
    println(Person.N_EYES)

    // Scala Object=Singleton Instance
    val mary = Person
    val john = Person
    println(mary==john)

    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary==john)
}
