package section13.classes

fun main() {

    val myComputer: Computer = Computer("Swift 3", "ACER")  // Reference type
    var myLaptop = myComputer                       // reference
    println(myLaptop.fullIdentity)

    println(myComputer.fullIdentity)

    // === Identity Operator

    if (myComputer === myLaptop){
        println("Laptop saya adalah komputer saya")
    } else {
        println("Laptop saya bukanlah komputer saya")
    }

    // Methods and Mutability
    val myComputer1 = Laptop("Macbook Pro", "Apple")
    myComputer1.ramCards.add(2)
    myComputer1.ramAmount = 8

    // Mutability and Constant
    val myAnimal = AnimalPractice("Tiger")

    // myAnimal.name = "Apple"    ERROR karena parameter adalah constant name bukan variable name
    // myAnimal = AnimalPractice("Lion")        ERROR karena myAnimal adalah constant bukan variable

    // Data Class
    val lg = TV("LG")
    println(lg)

    val samsung = TV("Samsung")
    println(samsung)

    val lgCopy = lg.copy()
    println(lgCopy)

    println(samsung == lg)      // membandingkan value
    println(lgCopy == lg)

    println(samsung === lg)     // mengecek apakah kedua variable ini mereferensikan memori yang sama
    println(lgCopy === lg)

    // Destructuring Declaration
    val (name) = samsung
    println(name)
    // val (cName) = myComputer     ERROR karena myComputer berisi class COMPUTER yang bukan merupakan data class

    val myShoes = Shoes("Adidas", 65)
    // val (name) = myShoes         ERROR karena sebelumnya sudah ada DD dengan nama yang sama yakni name
    val (nameShoes, sizeShoes) = myShoes
    println(nameShoes)
    println(sizeShoes)
}

// Create class
class Computer(var cName: String, var cBrand: String) {     // Primary Constructor to computer class

    val fullIdentity: String
    get() = "$cName adalah brand $cBrand"

}

// Methods and Mutability
class Laptop(var lName: String,
             var lBrand: String,
             val ramCards: MutableList<Int> = mutableListOf(),
             var ramAmount: Int = 0)

// Mutability and Constant
class AnimalPractice(val name: String)

// Data Class
data class TV(val name: String)
data class Shoes(val name: String, val size: Int)
