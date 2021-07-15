package section14.objects

/*
    Objects
    1. Instance
    2. Single Instance - Singletons
    3. Anonymous Object

    Singletons
    1. Only one instance - restrict class to only have one instance
    2. Global state - have to be careful when accessing
    3. Useful - because global state sometimes needed

    Named Object
    1. Named Object - a type that only have one instance
    2. No constructors
 */

// Processing Singleton Pattern -> MySingletonPractice.kt

/*
    Object vs Classes
    1. Properties and method - both can have this
    2. Properties initialize - properties in Object must be initialize, but not Classes
    3. Inheritance - Object can inherit from classes
    4. Interface - Object can also implements interface

    Static members
    1. Common to all instances - 1 Static Members for all instances
    2. Kotlin doesn't have static keyword, but they have Companion Object

    Anonymous Objects / Object Expression
    1. Override - implemented without Subclass
    2. Interface - implemented without creating concrete class
    3. Anonymous Instance - created this too
 */

fun main() {

    // Using Singleton
    val myLion = AnimalPractice(AnimalBookPractice.LION_NAME, "Yellow")
    val myTiger = AnimalPractice("Tiger", "Orange")
    val myPhanter = AnimalPractice("Phanter", "Black")

    AnimalBookPractice.addAnimal(myLion)
    AnimalBookPractice.addAnimal(myTiger)
    AnimalBookPractice.addAnimal(myPhanter)

    AnimalBookPractice.printAllAnimal()
    AnimalBookPractice.removeAnimal(myTiger)

    // Creating Companion Object

    // var myComputer = Computer()      ERROR karena constructor dari class Computer adalah private sehingga tidak dapat diakses secara langsung

    var myComputer = Computer.createNewComputer("Macbook", "Apple")

    println("${myComputer.cName} - ${myComputer.cBrand}")

    var macbookAir = Computer.createNewComputer("Macbook Air", "Apple")

    ComputerBook.addComputer(myComputer)
    ComputerBook.addComputer(macbookAir)
    ComputerBook.printComputers()

    // Anonymous Object
    val howMany = object : HowManyComputers {
        override fun numberOfComputers(): Int {
            return ComputerBook.allComputers.size
        }
    }
}

interface HowManyComputers {
    fun numberOfComputers(): Int

}