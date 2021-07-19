package section17.advancedclasses

/*
    1. Create 1 class
    2. Create 5 Subclasses
    3. Use the "is" and "as"
    4. Override the methods of superclasses
    5. Set the base class with 3 subtypes
    6. Create a Sealed class with 3 subtypes
    7. Create 1 secondary constructor in your subclasses
    8. Create 1 nested class
    9. Create 1 inner class
    10. Use Visibility Modifier
 */

fun main(){
    var myAnimal = Animal("Gobi", 2)
    val myPet = Pet("Tobi", 4)
    val myReptile = Reptile("Bobi", 3)

    // 3
    myAnimal = myPet

    println(myAnimal is Pet)
    println(myAnimal is Reptile)

    println((myReptile as? Animal)?.name)
    (myReptile as? Animal)?.eat()
    println(myAnimal as? Reptile)
    println(myPet as? Livestock)

    // 4
    val myMamalia = Mamalia("Kobi", 3)
    myMamalia.breath()
    myMamalia.feed()

    //10
    val myCar = Vehicle(4).Car(7)
    println(myCar.carDetail)

}

// 1
open class Animal(val name: String, val age: Int){
    fun eat(){
        println("$name sedang makan")
    }

    open fun breath(){
        println("Semua hewan bernafas")
    }

    // 5
    class Cat(name: String, age: Int)
    class Dog(name: String, age: Int)
    class Bird(name: String, age: Int)
}

// 2
open class Mamalia(name: String, age: Int): Animal(name, age){
    fun feed(){
        println("Semua mamalia menyusui anaknya")
    }

    override fun breath() {
        super.breath()
        println("Mamalia bernafas menggunakan paru-paru")
    }

    // 7
    constructor(name: String, age: Int, feet: Int, color: String) : this(name, age){
        println("Data mamalia : $name, $age, $feet, $color")
    }
}

open class Reptile(name: String, age: Int): Animal(name, age){
    fun coldBlood(){
        println("Reptil adalah hewan berdarah dingin")
    }

    // 7
    constructor(name: String, age: Int, feet: Int, tongue: String) : this(name, age){
        println("Reptile $name memiliki $feet kaki")
    }
}

open class Pet(name: String, age: Int): Animal(name, age){
    var animal: String = ""

    // 7
    constructor(name: String, age: Int, kept: Int): this(name, age){
        println("$name telah bersama kami selama $kept tahun")
    }
}

open class Livestock(name: String, age: Int): Mamalia(name, age){

    // 7
    constructor(name: String, age: Int, matureAge:Int): this(name, age){
        println("Hewan $name dapat dikatakan dewasa atau siap potong pada umur $matureAge")
    }
}

class Cow(name: String, age: Int): Livestock(name, age) {

    // 7
    constructor(name: String, age: Int, features: String): this(name, age){
        println("Sapi $name memiliki ciri khas $features")
    }
}

// 6
sealed class Poultry {

    class Chicken(val webbedClaw: String) : Poultry()
    class Duck(val swimmingBird: String) : Poultry()
    class Turkey(val bigBird: String) : Poultry()
}

// 8
class Vehicle(private val wheel: Int){      // 10
    class Motorcycle(val seat: Int){
        var motorInfo = "Dapat membawa $seat orang"
    }

    // 9
    inner class Car(val capacity: Int){
        var carDetail = "Cukup untuk $capacity orang dengan $wheel roda"
    }
}
