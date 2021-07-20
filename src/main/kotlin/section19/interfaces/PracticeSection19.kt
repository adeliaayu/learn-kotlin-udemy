package section19.interfaces

/*
    Interface
    1. No instantiation - Tidak bisa buat instance atau object
    2. Protocol - sets of methods or properties yang bisa digunakan class lain
 */

fun main() {
    val myPerson = Person()
    myPerson.sleep()
    myPerson.talk()
    myPerson.walk()

    println(myPerson.owns())
    println(myPerson.isDeveloper())

    // Interface Inheritance
    val myAndroidDeveloper = AndroidDeveloper("Jack", 25)
    myAndroidDeveloper.developAnApp()

    // Iterator
    val myAnimals = listOf("Lion", "Tiger", "Leopard", "Cat")
    val mySmartPhones = mapOf(1 to "iPhone", 2 to "Nexus", 3 to "HTC Desire")

    for (animal in myAnimals) { // list -> collection -> Iterable
        println(animal)
    }

    for (smartPhone in mySmartPhones.values) {// map -> map extension function
        println(smartPhone)
    }

    // Comparable
    val boxer1 = Boxer(100)
    val boxer2 = Boxer(200)

    println(boxer1.compareTo(boxer2))
}

interface PersonBehavior {

    val name: String
        get() = "John"

    fun sleep() {
        println("Sleep")
    }
    fun talk()
    fun walk()

    fun owns(device: ElectronicGadget = ElectronicGadget.iMac) : String

    fun isDeveloper() : Boolean
}

enum class ElectronicGadget {
    iPhone7,
    Macbook,
    iMac,
    iPod,
    iPad
}

class Person : PersonBehavior {

    override val name: String = "Mory"

    override fun sleep() {
        super.sleep()
        println("The person is sleeping")
    }

    override fun talk() {
        println("The person is talking")
    }

    override fun walk() {
        println("The person is walking")
    }

    override fun owns(device: ElectronicGadget): String {
        return device.name
    }

    override fun isDeveloper(): Boolean {
        return true
    }
}

// Interface Inheritance
interface PersonIDea {

    val name: String
    val age: Int

    fun sleep()
    fun walk()
    fun talk()

}

interface DeveloperIdea: PersonIDea {       // inherit dari interface PersonIDea

    val mainProgrammingLanguage: String
    val mainPlatform: String

    fun developAnApp()

}

class AndroidDeveloper(val developerName: String, val developerAge: Int) : DeveloperIdea {  // Harus implement kedua interface

    override val mainProgrammingLanguage: String
        get() = "Kotlin"
    override val mainPlatform: String
        get() = "Android"

    override fun developAnApp() {
        println("Develop an Android App")
    }

    override val name: String
        get() = developerName

    override val age: Int
        get() = developerAge

    override fun sleep() {
        println("The Developer is sleeping")
    }

    override fun walk() {
        println("The Developer is walking")
    }

    override fun talk() {
        println("The Developer is talking")
    }
}

// Comparable
class Boxer(val punchPower: Int) : Comparable<Boxer> {

    override fun compareTo(other: Boxer): Int {
        return when {
            punchPower > other.punchPower -> 1
            punchPower == other.punchPower -> 0
            else -> -1
        }
    }
}

