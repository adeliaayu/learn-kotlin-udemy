package section13.classes

/*
    1. Create 5 Classes
    2. Create 5 References to each class
    3. Use the identity operator
    4. Create 3 data classes
    5. Use Destructuring Declaration to extract data
 */

fun main(){
    //2
    var myCar =  Car("Ignis", "Suzuki", "City Car")
    var myIgnis = myCar
    var pajero = Car("Pajero", "Mitsubishi", "SUV")
    println(myIgnis.name)

    var myMotor =  Motor("Vario", "Honda" )
    var myVario = myMotor
    myVario.forward()

    var myPhone = Phone("A52", "Samsung", "A52353")
    var mySamsung = myPhone
    println(mySamsung.type)

    var myAnimal = Animal(4, "Forest", "Lion")
    var myLion = myAnimal
    println(myLion.feet)

    var myFruit = Fruit("Apple","Sweet","Small")
    var myApple = myFruit
    println(myApple.taste)

    //3
    if (myCar === myIgnis){
        println("Mobil ini adalah Ignis saya")
    } else {
        println("Mobil ini bukanlah Ignis saya")
    }

    if (myCar === pajero){
        println("Mobil pajero ini bukanlah milik saya")
    } else {
        println("Mobil pajero ini adalah milik saya")
    }

    //4
    val namaTeman = Name(1, "Ahdin")
    val nilaiKelas = Grade(1, 78)
    val umurTeman = Age("Kordin", 18)

    //5
    val (absenTeman, nama) = namaTeman
    println(absenTeman)
    println(nama)
}

//1
class Car (var name: String, var brand: String, var type: String){
    fun turning() {
        println("A car can turn")
    }
}

class Motor (name: String, brand: String){
    fun forward(){
        println("Motors can move forward")
    }
}

class Phone (var type: String, var brand: String, var idSeries: String)

class Animal (var feet: Int, var habitat: String, var name: String){

    var fur: String = ""
    fun eat(){
        println("Every animals need to eat")
    }
}
class Fruit (var name: String, var taste: String, var size: String){
    fun serving(){
        println("Fruits need some preparation before being served")
    }
}

//4
data class Name(val absen: Int, val name: String)
data class Grade(val absen: Int, val grade: Int)
data class Age(val name: String, val age: Int)