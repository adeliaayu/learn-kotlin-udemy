package section15.properties

import kotlin.math.roundToInt
import kotlin.math.sqrt

import kotlin.properties.Delegates

/*
    Properties
    1. Custom accessors
    2. Backing field

    Content
    1. Properties
    2. Properties Initializers
    3. Custom Accessors
    4. Delegated Properties
    5. Late Initialization
    6. Extension Properties

    Delegated Properties - to initialize property
    1. Literal value
    2. Default value
    3. Computing the value
    4. Passing off
    5. Delay
    6. Observe
 */

fun main() {

    // Constructor Properties
    var firstJob = Job(name = "Java Programming")
    // firstJob.name = "Kotlin Programming"         ERROR karena name adalah constanta bukan variable, tidak bisa di reassign
    println(firstJob.name)                          // instance properties -> dapat diakses dengan nama variable

    Job.salary =
        1000                           // hanya bisa akses dengan nama Class karena bersifat static dan accesible disemua instance
    println(Job.salary)
    var secondJob = Job("Swift Programming")
    println(secondJob.name)

    Job.salary = 3000
    println(Job.salary)

    // Default Value
    var thirdJob =
        Job()            // tidak perlu mengisi parameter class Job karena sudah ada default valuenya yakni Accountant

    println(firstJob.jobDefinition)
    println(secondJob.jobDefinition)

    // Property Initializer
    val myComputer = Computer()
    println(myComputer.cpuKind)

    // Custom Getter and Setter
    val math = MyMath(15.5, 10.8, 2.7, 12.4)

    println(math.squareHeight)
    println(math.squareArea)
    println(math.rectangleArea)
    println(math.numberSquareRoot)

    math.squareArea = 7
    println(math.squareArea)

    math.squareHeight = 5.5
    math.numberSquareRoot = 16
    println(math.numberSquareRoot)

    // Companion Object Properties
    val boxer1 = Boxer(100, 200)
    Boxer.numberOfBoxers++              // langsung akses companion object properties
//    boxer1.newBoxerCreated = true
    println(Boxer.numberOfBoxers)

    val boxer2 = Boxer(250, 100)
//    Boxer.numberOfBoxers++
    boxer2.newBoxerCreated = true           // Menggunakan observable properties
    println(Boxer.numberOfBoxers)

    // Variable Limitation
    val myLaptop = Laptop("Macbook Pro", "Apple")
    myLaptop.orderedRamAmount = 128
    println(myLaptop.orderedRamAmount)

    // Lazy properties
    val myDownloadObject = Download()       // Will not be executed until it is required / accessed
    // Profile Picture is not being downloaded at this point
    println(myDownloadObject.downloadProfilePic)
    val myMath = Mathematic()
    println(myMath.heavyCalculation)

    // Late init
    val myPC = PC()
    myPC.cpu = "Core i7 7th Generation"
    println(myPC.cpu)

    // Extension Properties
    val mathObject = MyMathematic(9.0)
    println(mathObject.numberSquareRoot)
}

class Job(val name: String = "Accountant") {            // name disini disebut instance variable, karena tiap instance hanya dapat mengakses instance properties nya masing2

    // Property Initializer
    val jobDefinition =
        "Job as an $name is tough"      // penggunaan name dalam variable jobDefinition disebut Property Initializer

    companion object {
        var salary = 0          // variable ini akan dapat diakses oleh seluruh instance, sifatnya static
    }
}

// Property Initializer
class Computer {
    val name: String = ""
    val brand: String           // constant ini di initialize menggunakan init
    val cpuKind: String? = null     // meskipun null, ini berarti juga sudah di initialize

    init {                  // digunakan untuk menginisialisasi properti
        brand = ""
    }
}

// Custom Getter and Setter
class MyMath(var squareHeight: Double, val rectangleWidth: Double, val rectangleHeight: Double, var number: Double) {

    var squareArea: Int         // get harus menggunakan constant (val) jika tidak diinisialisasi atau tidak ada set
        get() {                                 // get squareArea akan mengembalikan nilai yang telah diproses terlebih dahulu
            return (squareHeight * squareHeight).roundToInt()
        }
        set(value) {                     // value disini refer to squareArea atau variable yang di set
            squareHeight = value.toDouble()
        }

    val rectangleArea: Int
        get() {
            val areaResult = (rectangleWidth * rectangleHeight).roundToInt()
            return areaResult
        }

    var numberSquareRoot: Int               // harus merupakan variable untuk memiliki setter
        get() = sqrt(number).roundToInt()
        set(value) {
            number = value.toDouble()
        }

    var rectangleHeight2Times: Int = 0         // Apabila tidak memiliki setter, variabel harus diinisialisasi
        get() {
            return (rectangleHeight * rectangleHeight).roundToInt()
        }
}

// Companion Object Properties
class Boxer(val punchPower: Int, val punchSpeed: Int) {
    companion object {
        var numberOfBoxers = 0
    }

    // Observable Properties
    var newBoxerCreated: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfBoxers++
        }
    }
}

// Variable Limitation
class Laptop(name: String, brand: String) {

    companion object {
        var maximumRamAmount = 128
    }

    var orderedRamAmount by Delegates.vetoable(0)
    { _, _, newValue ->
        if (newValue > maximumRamAmount) {
            println("A Laptop with this amount of ram can not be ordered")
            false
        } else {
            true
        }
    }
}

// Lazy properties
class Download {
    val downloadProfilePic:String by lazy {         // Will not be executed until it is required / accessed
        "Downloading Profile picture"
    }
}

class Mathematic {
    val heavyCalculation: Int by lazy {
        2*7+4/5*9+10
    }
}

// Late init
class PC {
    val ram: String = "16 GBs"
    val graphicCard: String = "4 GBs"
    val powerSupply: String = "1000"

    lateinit var cpu: String
}

// Extension Properties
val MyMathematic.numberSquareRoot: Double
    get() = Math.sqrt(number)

class MyMathematic(val number: Double){}
