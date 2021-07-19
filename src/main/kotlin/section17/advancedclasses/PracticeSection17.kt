package section17.advancedclasses
/*
    Advanced Classess
    1. Inheritance
    2. Overriding
    3. Polymorphism
    4. Composition

    Contains of
    1. Constructing
    2. Class Hierarchy
    3. Class Lifecycle

    Why Inheritance
    1. Single Responsibility - Any class should have single concern
    2. Exclusive Type - in Fighter -> Boxer relation, we can add properties to Boxer tanpa ada koneksi ke Fighter
    3. Class Foundation - Bisa akses properties yang ada di class foundation/ base class dengan behavior masing2 sesuai classnya
    4. Extend - bisa extend behavior dari kelas yang tidak boleh diubah
 */

fun main() {
    // Inheritance
    var myPerson1 = Person1("John", 20)
    println(myPerson1.giveMeTheFullIdentity())

    var myEmployee = Employee("Monica", 25)         // dapat mengakses funtion milik parent class
    println(myEmployee.giveMeTheFullIdentity())

    // myPerson1.id             ERROR karena id ada di Employee
    myEmployee.id = 10

    // Polymorphism
    println(giveMePersonAge(AndroidDeveloper("Paul", 27))) // tapi bisa dimasukin child classnya karna dia turunannya

    // Checking runtime hierarchy
    val myAndroidDeveloper = AndroidDeveloper("Paul", 27)

    myEmployee = myAndroidDeveloper

    println(myEmployee is Person)
    println(myEmployee is AndroidDeveloper)
    println(myEmployee !is IOSDeveloper)

    //  myPerson.mainProgrammingLanguages           ERROR karena func itu ada di AndroidDeveloper padahal myPerson adalah Person
    // as infix operator
    // println(myPerson as IOSDeveloper)        ERROR karena class AndroidDeveloper tidak bisa di cast sebagai IOSDeveloper
    println(myEmployee as? IOSDeveloper)      // return null
    println((myEmployee as? AndroidDeveloper)?.mainProgrammingLanguages?.joinToString())      // casting myPerson menjadi AndroidDeveloper
    println(hobbies(myEmployee as? Person))       // harus menggunakan ? agar apabila gagal tidak akan terjadi error

    // Inheritance Methods and Override
    val myAndroidDeveloper1 = AndroidDeveloper("Paul", 27)
    myAndroidDeveloper1.developAnApp()
    myAndroidDeveloper1.developAnAndroidWidget()

    // Abstract Class
    // val myPerson = Person("John", 34)        ERROR karena abstract class tidak bisa di instance langsung, harus diturunkan dulu baru diinstance
    val myEmployeeAbstract = Employee("Paul", 27)
    myEmployee.sleepAt10PM()

    // Sealed Classes
//    val myBoxer = Fighter.Boxer(400)          ERROR GATAU KENAPA

    // Secondary Constructor
    val myPeople = Person1("Female", "Suzan", 27)
    val myPeople2 = Person1("Male", "Mory", 25, "Programmer")
    val myEmployeeSecondary = Employee1("Male", "John", 35, "Acountant")

    // Nested and Inner Class
    val myBoxer = MMAFighter(400).Boxer(300)         // Untuk mengakses inner class harus menggunakan outer class
    println(myBoxer.boxerDetails)                   // apabila parameter outer class dibutuhkan maka harus diisi

    val myTaeKwon = MMAFighter.TaeKwonDo(500)       // tidak perlu mengisi parameter outer class karena tidak dibutuhkan
    println(myTaeKwon.taekwonDetails)

    /*
        Visibility Modifier
        1. Public - default di kotlin, visible from anywhere
        2. Private - cannot be accessed outside it's class or file
        3. Protected - only subclasses can access
        4. Internal - only visible for inside the same module

        Best Practice - Always limit visibility to avoid problems that might happen
     */

    // Visibility Modifier
    val myIphone = IPhone("iPhone 7", "Apple", 2)
    println(myIphone.iPhoneDetails)
}

// Checking runtime hierarchy
fun hobbies(person: Person?): String {
    return "Boxing, Swimming"
}

fun hobbies(androidDeveloper: AndroidDeveloper?): String {
    return "Yoga, Tai chi"
}

// Polymorphism
fun giveMePersonAge(person: Person): Int {         // mintanya class person
    return person.age
}

// Inheritance
open class Person1(val name: String, val age: Int) {         // class by default adalah FINAL Class, agar class ini dapat di inherit ke class lain maka harus menjadi OPEN class
    fun giveMeTheFullIdentity() = "$name $age"          // final class by default ini membuat kode menjadi lebih efisien karna tidak perlu mencari apabila ada subtype atau tidak

    // Secondary Constructor
    constructor(gender: String, name: String, age: Int) : this(name, age) {
        if (gender.contains("Male")) {
            println("The Gender is male")
        } else if (gender.contains("Female")) {
            println("The gender is female")
        }
    }

    constructor(gender: String, name: String, age: Int, job: String): this(gender, name, age)
}
// Secondary Constructor
class Employee1(gender: String, name: String, age: Int, job: String) : Person1("Name", 0) {}


// Abstract Classes
abstract class Person(val name: String, val age: Int) {
    fun giveMeTheFullIdentity() = "$name $age"

    abstract fun sleepAt10PM()          // abstract func tidak boleh memiliki isi/body
}

open class Employee(name: String, age: Int) : Person(name, age) {        // karena class Employee sudah inherit properties dari class Person maka tidak perlu properties lagi (tidak usah var/val) cukup parameter saja
    var id: Int = 0

    override fun sleepAt10PM() {                    // abstract function pada abstract class wajib di override di subclass
        println("Employee sleeps at 10 pm")         // abtract function baru diberikan body di class turunan
    }
}

open class Developer(name: String, age: Int) : Employee(name, age) {
    // Inheritance Methods and Override
    open fun developAnApp() {
        println("An App is created")
    }
}

class AndroidDeveloper(name: String, age: Int) : Developer(name, age) {     // bisa saja apabila ingin menambahkan properties pada child class

    var mainProgrammingLanguages = arrayOf("Java", "Kotlin")

    // Inheritance Methods and Override
    override fun developAnApp() {
        super.developAnApp()                // super refers to nearest implementing superclass, and calling the function on that class
        println("Android App is Developed")         // best practicenya super harus paling atas
    }

    fun developAnAndroidWidget() {
        println("An Android App Widget is Developed")
    }
}

class IOSDeveloper(name: String, age: Int) : Developer(name, age) {

    var mainProgrammingLanguages = arrayOf("Swift", "Objective-C")
}

// Sealed Class
sealed class Fighter {

    class Boxer(val punchPower: Int) : Fighter()
    class KickBoxer(val kickPower: Int) : Fighter()

    val myBoxer = Boxer(100)
    val myKickBoxer = KickBoxer(200)

    val boxerB = Boxer(500)
    val kickBoxerB = KickBoxer(300)

    fun giveMeTheFighterPower(fighter: Fighter) : Int {
        return when (fighter) {
            is Fighter.Boxer -> fighter.punchPower
            is Fighter.KickBoxer -> fighter.kickPower
        }
    }

    fun giveMeMyBoxerPunchPower() = myBoxer.punchPower
}

// Nested and Inner Class
class MMAFighter(val stamina: Int) {

    // Nested Class
    class TaeKwonDo(val kickPower: Int){
        // val taekwonDetails = "$kickPower $stamina"       ERROR di Stamina karna TaeKwonDo bukan inner class dari MMAFighter
        val taekwonDetails = "$kickPower"
    }

    // Inner Class
    inner class Boxer(val punchPower: Int) {
        val boxerDetails = "$punchPower $stamina"
    }
}

// Visibility Modifier
open class Computer(val name: String, private val brand: String, protected val ram: Int)

class IPhone(name:String, brand: String, ram: Int) : Computer(name, brand, ram) {

    val iPhoneDetails: String       // ram dapat diakses dikelas ini karena Iphone adalah turunan dari Computer
        get() = "$name - $ram"      // brand tidak dapat diakses di class ini karna private
}


