package section18.enumclasses

/*
    Enums
    - type class with limited sets of value
    ex: Sport hanya 3 value saja : boxing, kick-boxing, karate
 */

fun main(){
    for (mySport in Sport.values()) {
        println("Sport #${mySport.ordinal} - ${mySport.name}")
    }

    val firstSport = Sport.values()[0]
    println(firstSport)
    val judoIndex = Sport.valueOf("Judo").ordinal
    println(judoIndex)

    // val firstSportIndex = Sport.valueOf("Aikido").ordinal        ERROR karena tidak ada value tersebut dalam enum class
    // println(firstSportIndex)

    // Enums Properties and Function
    for (animal in Animal.values()) {
        println("Animal #${animal.ordinal} - ${animal.name} - is wild? ${animal.isWild}")
    }

    val randomAnimalWinner: Animal = Animal.randomWinner()
    println("The random winner is $randomAnimalWinner")

    val myAnimal = Animal.Leopard
    myAnimal.sleep()

    // Enums vs When
    val mySmartPhone = SmartPhone.XPeria

    when (mySmartPhone) {
        SmartPhone.iPhone -> println("Apple")
        SmartPhone.GalaxyS9 -> println("Samsung")
        SmartPhone.Nexus -> println("Google")
        else -> println("Unknown Brand")
    }

    /*
        Enums vs Sealed Class

        Sealed Class
        1. Abstract - sealed class adalah abstract class sehingga boleh memiliki abstract members
        2. Abstract members - subclass must implement those abstract members
        3. Multiple Instance - each sealed class and its subclass can have multiple instances
        4. Private - sealed class can not have subclass outside its file, constructor always private
        5. Private Subclasses - can not inherit from its subclasses outside its file
     */

    // Sealed Class
    val myDeveloper = Developer.AndroidDeveloper()
    myDeveloper.hoursWorked = 150
    println("Here it is my developer: ${myDeveloper.developerName} - and the monthly salary of my developer is ${myDeveloper.monthlySalary} - The annual salary of my developer is ${myDeveloper.annualSalaryBasedOnHoursWorked()}")

    // Enumeration and State Machine
    val myPerson = Person("Mory")
    myPerson.printMood(Mood.Happy)

    // Integrate Nullability to your enums
    val myPerson1 = Person1("Judy")
    myPerson1.printMood(Mood1.Sad)
    myPerson1.printMood(null)


}

// Case order modification - Langsung mengubah urutan value enum class dengan cara memindahkannya
enum class Sport{
    Boxing,
    Karate,
    TaiChi,
    Yoga,
    Judo;              // operator ; berfungsi untuk menandakan bahwa sudah tidak ada value lagi setelah value tersebut
}

// Enums Properties and Function
enum class Animal (val isWild: Boolean = true) {

    Lion,
    Dolphin(false),
    Leopard,
    Tiger,
    Elephant(false),
    Bird(false),
    Bear,
    Cat(false);         // operator ; wajib apabila ingin menambahkan object atau method setelah instance

    companion object {          // kenapa pake ini, karna harus bisa diakses oleh semua instance dalam enum class dengan nilai static
        fun randomWinner() : Animal {
            return Animal.values()[(0..Animal.values().size).random()]
        }
    }

    fun sleep() {
        println("$this is sleeping")
    }
}

// Enums vs When
enum class SmartPhone {
    iPhone,
    Nexus,
    GalaxyS9,
    XPeria;
}

// Sealed Class
sealed class Developer {

    abstract val monthlySalary: Int
    abstract val hourlyWage: Int
    var hoursWorked = 0

    fun annualSalaryBasedOnHoursWorked() : Int {
        return hoursWorked * hourlyWage

    }

    class AndroidDeveloper : Developer() {
        override val monthlySalary: Int
            get() = 10000
        override val hourlyWage: Int
            get() = 100
    }

    class IOSDeveloper : Developer() {

        override val monthlySalary: Int
            get() = 9000
        override val hourlyWage: Int
            get() = 90
    }

    class WebDeveloper : Developer() {

        override val monthlySalary: Int
            get() = 8000
        override val hourlyWage: Int
            get() = 80

    }

    val developerName: String
        get() = when (this) {
            is AndroidDeveloper -> "Android Developer"
            is IOSDeveloper -> "iOS Developer"
            is WebDeveloper -> "Web Developer"

        }
}

// Enumeration and State Machine
enum class Mood {
    Happy,
    Numb,
    Sad
}

class Person(val name: String) {
    fun printMood(mood: Mood) {
        println("${this.name} is $mood")
    }
}

// Integrate Nullability to your enums
enum class Mood1 {
    Happy,
    Sad
}

class Person1(val name: String) {
    fun printMood(mood: Mood1?) {
        when (mood) {
            Mood1.Happy -> println("${this.name} is Happy Now")
            Mood1.Sad -> println("${this.name} is Sad Now")
            null -> println("${this.name} is Numb Now" )
        }
    }
}