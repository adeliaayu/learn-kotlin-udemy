package section16.methods

fun main() {

    // Methods - Function inside a class or object
    val myAnimals = mutableListOf<String>()
    myAnimals.add("Lion")
    myAnimals.add(0, "Tiger")
    println(myAnimals.joinToString())

    // Methods vs Getter and Setter
    val myBoxer = Boxer(150, 200)
    println(myBoxer.overallPerformance)

    myBoxer.overallPerformance =  100
    println(myBoxer.overallPerformance)

    // Function Conversion to Method
    val myMobile = Mobile("iPhone X")
    val myApp = Application("What's App")

    myMobile.installApp(myApp)

    // Method Object
    println(MyMath.giveMeTheSquareRootOfNumber(10))

    // Extension Methods
    val mathObject = MyMathematic(20)
    println(mathObject.isItODD())

    // Companion Object Extension
    println(MyMathCompanion.giveMeTheMaximumValue(2, 5))
}

// Methods vs Getter and Setter
class Boxer(var punchPower: Int, var punchSpeed: Int) {

    var overallPerformance: Int
        get() = punchPower * punchSpeed
        set(value) {
            punchPower = punchPower + value
            punchSpeed = punchSpeed + value
        }
}

// Function Conversion to Method
class Mobile(val name: String) {

    fun installApp(app: Application) {
        println("${app.name} is installed on ${this.name}")         // Introduction to "this" Keyword
    }
}

class Application(val name: String) {}


// Method Object
class MyMath(val myNumber: Int) {

    companion object {
        fun giveMeTheSquareRootOfNumber(number: Int): Int {
            return Math.sqrt(number.toDouble()).toInt()
        }
    }
}

// Extension Method
fun MyMathematic.isItODD() : Boolean {
    if (myNumber % 2 == 0) {
        return false
    } else {
        return true
    }
}

class MyMathematic(val myNumber: Int) {

    companion object {
        fun giveMeTheSquareRootOfNumber(number: Int): Int {
            return Math.sqrt(number.toDouble()).toInt()
        }
    }
}

// Companion Object Extension
fun MyMathCompanion.Companion.giveMeTheMaximumValue(firstNum: Int, secondNum: Int) : Int {
    return Math.max(firstNum, secondNum)
}

class MyMathCompanion(val number: Int) {

    companion object {
        fun giveMeTheSquareRootOfNumber(number: Int): Int {
            return Math.sqrt(number.toDouble()).toInt()
        }
    }
}
