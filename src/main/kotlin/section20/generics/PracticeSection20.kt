package section20.generics

/*
    Generics
    1. Centralizing Code
    2. Type Simplicity - we don't have to know what type we're dealing with

    Type Erasure - Generic type tidak mengecek type datanya, hanya valuenya saja yang dicek
                 - Baik pada interface ataupun class
 */

fun main(){

    // Lists
    val animalLists = listOf("Lion", "Tiger", "Elephant","Leopard")
    println(animalLists)
    println(animalLists.first())

    val prices = mutableListOf(2.5, 3.9, 3.5)
    prices.add(4.2)                     // Generic typenya double, diisi string tidak bisa
    // prices.add("Lion")       ERROR karena generic nya type double bukan string

    val pricesAny: MutableList<Any> = mutableListOf<Any>(5.2, 6.3, 2.4)
    pricesAny.add("Animal")
    println(pricesAny)

    // Maps
    val myMap = mapOf(1 to "Lion",      // Best practice - key harus sama type nya, valuenya boleh beda2 (Any)
        2 to 5.9,
        3 to true)

    //  println(myMap.get(false))       ERROR karena type inferencenya adalah Int jadi kalo dimasukin boolen nggak bisa
    //  myMap[true]

    val myKeySet = myMap.keys
    println(myKeySet)

    val myAnyCollection = myMap.values
    println(myAnyCollection.joinToString())

    // Extension functions vs Generic constraints
    val animalList = listOf("Lion", "Tiger", "Elephant", "Leopard", "Cat")
    println(animalList.orderByStars())

    val myAnyList: List<Any> = listOf(1, "Cat", 5.7, true)
    println(myAnyList.orderByStars())

    // Creating Generic Constraint
    val gamingConsoles = listOf(GamingConsole("PS4"),
                                GamingConsole("XBOX One"),
                                GamingConsole("PS4 Pro"),
                                GamingConsole("XBOX One X"))
    val gamingConsoleShopper = Shopper(gamingConsoles)

//    gamingConsoleShopper.bringShoppingThingsToCar()
    gamingConsoleShopper.bringShoppingThingsToHome()
    gamingConsoleShopper.finalize()

    val htcOne = SmartPhone("HTC One", true)
    val smartPhones = listOf(
        SmartPhone("iPhone X", false),
        SmartPhone("Nexus 5", false),
        SmartPhone("Galaxy S9", false),
        SmartPhone("Xperia Z3", false),
        htcOne)
    val smartPhoneShopper = Shopper<SmartPhone>(smartPhones)

    // Generic Interfaces
    smartPhoneShopper.bringBoxesOrShoppingThingsToCar(SmartPhoneBox())
    smartPhoneShopper.bringShoppingThingsToHome()
    smartPhoneShopper.finalize()
}

// Extension functions vs Generic constraints
fun List<Any>.orderByStars() : String {         // extension functionsnya adalah orderByStars, kemudian generic constraintnya adalah <Any>
    val mySeparator = "\n ***"
    return this.map { "$it" }.joinToString(mySeparator, mySeparator, "\n")
}

// Creating Generic Constraint
class Shopper<T: Testable>(shoppingThings: List<T>) {

    private var shoppingThingsInStore = mutableListOf<T>()
    private var shoppingThingsInCar = mutableListOf<Any>()
    private var shoppingThingsInHome = mutableListOf<T>()
    private var defectiveShoppingThings = mutableListOf<T>()

    init {
        shoppingThingsInStore.addAll(shoppingThings)
    }

    fun bringBoxesOrShoppingThingsToCar(firstBox: Box<T>?) {
        var currentBox = firstBox

        while (shoppingThingsInStore.count() > 0) {
            val shoppingThing = shoppingThingsInStore.removeAt(0)

            if (shoppingThing.testIsFine()) {
                if (currentBox != null) {
                    if (!currentBox.hasBoxMoreSpace()) {
                        bringBoxToCar(currentBox)
                        currentBox = currentBox.getNewBox()
                    }
                    currentBox.addShoppingThingToBox(shoppingThing)
                } else {
                    shoppingThingsInCar.add(shoppingThing)
                    println("brought the $shoppingThing to the car")
                }
            } else {
                defectiveShoppingThings.add(shoppingThing)
                println("There is something wrong with $shoppingThing. Let's bring it back to store")
            }
        }

        currentBox?.let {
            bringBoxToCar(it)
        }
    }

    fun bringShoppingThingsToHome() {

        //  val gamingConsoles = shoppingThingsInCar.filterIsInstance<GamingConsole>()
        //  gamingConsoles
        val boxes = shoppingThingsInCar.filterIsInstance<Box<T>>()
        for (box in boxes) {
            shoppingThingsInCar.remove(box)
            while (!box.isBoxEmpty()) {
                val shoppingThingInBox = box.removeShoppingThingFromBox()
                println("Unboxing the $shoppingThingInBox")
                bringTheActualShoppingThingToHome(shoppingThingInBox)
            }
        }

        while (shoppingThingsInCar.count() > 0) {

            @Suppress("UNCHECKED_CAST")
            val shoppingThing = shoppingThingsInCar.removeAt(0) as? T

            if (shoppingThing != null) {
                bringTheActualShoppingThingToHome(shoppingThing)
            } else {
                println("There is a null in the car. Sorry")
            }
        }
    }

    private fun bringTheActualShoppingThingToHome(actualShoppingThing: T) {
        shoppingThingsInHome.add(actualShoppingThing)
        println("Brought the $actualShoppingThing to home")
    }

    fun finalize() {
        println("The things that you have bought are $shoppingThingsInHome")
        if (!defectiveShoppingThings.isEmpty()) {
            println("The things that we couldn't buy were $defectiveShoppingThings")
        }
    }

    private fun bringBoxToCar(box: Box<T>) {
        shoppingThingsInCar.add(box)
        println("Brought a box of ${box.listOfShoppingThings()} to the car")
    }
}

class GamingConsole(val name: String) : Testable {

    override fun toString(): String {
        return name
    }

    override fun testIsFine(): Boolean {
        return true
    }
}

class SmartPhone(val name: String, val defectiveBattery: Boolean) : Testable {
    override fun toString(): String {
        return name
    }

    override fun testIsFine(): Boolean {
        return !defectiveBattery
    }
}

interface Testable {
    fun testIsFine() : Boolean
}

// Generic Interfaces
interface Box<T> {

    fun hasBoxMoreSpace() : Boolean
    fun addShoppingThingToBox(shoppingThing: T)
    fun isBoxEmpty() : Boolean
    fun removeShoppingThingFromBox() : T
    fun getNewBox() : Box<T>
    fun listOfShoppingThings() : List<T>

}

class SmartPhoneBox : Box<SmartPhone> {

    private val allSmartPhones = mutableListOf<SmartPhone>()
    override fun hasBoxMoreSpace(): Boolean {
        return allSmartPhones.count() < 5
    }

    override fun addShoppingThingToBox(shoppingThing: SmartPhone) {
        allSmartPhones.add(shoppingThing)
    }

    override fun isBoxEmpty(): Boolean {
        return allSmartPhones.count() <= 0
    }

    override fun removeShoppingThingFromBox(): SmartPhone {
        val lastSmartPhone = allSmartPhones.last()
        allSmartPhones.remove(lastSmartPhone)
        return lastSmartPhone
    }

    override fun getNewBox(): Box<SmartPhone> {
        return SmartPhoneBox()
    }

    override fun listOfShoppingThings(): List<SmartPhone> {
        return allSmartPhones.toList()
    }
}