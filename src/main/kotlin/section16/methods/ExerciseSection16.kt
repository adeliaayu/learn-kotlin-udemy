package section16.methods

/*
    1. Create 5 Classes
    2. Create 2 Methods in each Class
    3. Use the "this" keyword
    4. Create 5 Object Methods
    5. Create 5 Extension Methods
    6. Create 5 Companion object extension methods
 */

// 1
class Animal(val name: String, val feet: Int){
    fun eat(){
        println("$name sedang makan")
    }

    fun move(){
        if (feet > 0){
            println("$name sedang berjalan dengan $feet kakinya")
        } else {
            println("$name berpindah tempat tidak menggunakan kaki")
        }
    }

    companion object{
        fun latinName(){
            println("Semua hewan memiliki nama latinnya sendiri")
        }
    }
}

fun Animal.isSwimming(able: Boolean){
    if (able){
        println("$name bisa berenang")
    } else {
        println("$name tidak bisa berenang")
    }
}

fun Animal.Companion.sleep(){
    println("Semua hewan membutuhkan tidur")
}

class Person(val name: String, var age: Int){
    fun eat(){
        println("${this.name} makan menggunakan sumpit")
    }

    fun aging(){
        println("${this.name} berumur $age dan bertambah tiap tahunnya")
    }

    companion object{
        fun mamalia(){
            println("Semua manusia adalah mamalia")
        }
    }
}

fun Person.old(){
    when(age){
        in 1..30 -> println("Young")
        in 31..50 -> println("Middle Age")
        in 51..100 -> println("Old")
        else -> println("Very Old")
    }
}

fun Person.Companion.feet(){
    println("Manusia pada umumnya memiliki dua kaki")
}

class Electronic(val name: String, val function: String, val color: String) {
    fun function() {
        println("$name berfungsi untuk $function")
    }

    fun coloring() {
        println("$name berwarna $color")
    }

    companion object {
        fun needElectricity() {
            println("Elektronik membutuhkan listrik untuk berfungsi")
        }
    }
}

fun Electronic.isCableNeeded(cable: Boolean){
    if (cable){
        println("$name membutuhkan kabel untuk mengoperasikannya")
    } else {
        println("$name tidak menggunakan kabel")
    }
}

fun Electronic.Companion.electricitySource(){
    println("Sumber listrik dapat dari colokan atau baterai")
}

class Vegetable(val name: String, val color: String){
    fun served(){
        println("$name disajikan dengan cara dipotong")
    }

    fun isGreens(){
        println("Sayur $name adalah sayuran $color")
    }

    companion object{
        fun notFruit(){
            println("Sayuran berbeda dengan buah")
        }
    }
}

fun Vegetable.delicious(){
    println("Sayur $name adalah sayur yang lezat bagi penggemarnya")
}

fun Vegetable.Companion.consumable(){
    println("Semua sayuran dapat dikonsumsi")
}

class Furniture(val name: String, val material: String, val uses: String){
    fun information(){
        println("$name terbuat dari $material")
    }

    fun function(){
        println("$name digunakan untuk $uses")
    }

    companion object{
        fun universalUse(){
            println("Semua furnitur digunakan untuk membantu pekerjaan manusia")
        }
    }
}

fun Furniture.usedTogether(){
    println("$name dapat digunakan bersama-sama")
}

fun Furniture.Companion.commonMaterial(){
    println("Biasanya furnitur terbuat dari besi ataupun kayu")
}