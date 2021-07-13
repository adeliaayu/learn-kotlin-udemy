package section10.arraysandlists

import com.sun.org.apache.xpath.internal.operations.Bool

fun main(){

    // Arrays in Kotlin
    var animalNames: Array<String> = arrayOf("Lion", "Elephant", "Squid")
    println(animalNames.get(0))

    var oddNumber: Array<Int> = arrayOf(1,3,5,7)
    println(oddNumber.get(1))

    var lions = Array(5, {"Lion"}) // kurung kurawal itu akan menjadi default value dari array
    println(lions.get(4))
    //println(lions.get(5)) // ERROR karena index terakhir adalah size-1

    val iphone = arrayOf("iphone 4", "iphone 5") // Array dapat dibuat menggunakan constant (val) apabila tidak akan diubah valuenya

    // Arrays of Primitive Type
    var oddNumber1 = intArrayOf(1,3,5,7) // Digunakan untuk optimize proses dari baris kode, primitive type, bukan object
    println(oddNumber1)

    var prices = doubleArrayOf(3.4, 5.3, 3.5)
    println(prices.get(0))

    floatArrayOf()
    booleanArrayOf()
    byteArrayOf()
    shortArrayOf()

    var fiveZeroes = IntArray(8) // Default value nya adalah Int yakni angka 0 tanpa perlu didefinisikan
    println(fiveZeroes.get(4))

    // Convert object array to primitive array
    var evenNumber = arrayOf(2, 4, 6, 8).toIntArray()

    // List in Kotlin
    /*
    List in an interface
    1. Concrete realization in ArrayList
    2. Arrays > Lists
    3. Dynamically-sized
     */

    // Immutable List
    val fruitList = listOf("Apple", "Orange", "Cucumber")
    val fruitArrayList = arrayListOf("Apple", "Orange", "Cucumber")

    println(fruitList.get(0))
    println(fruitArrayList.get(1))

    val emptyList: List<Int> = listOf()
    val emptyArrayList: ArrayList<Double> = arrayListOf()

    // Mutable List
    val fruitMutableList = mutableListOf("Apple", "Orange", "Cucumber")
    val fruitMutableArrayList = arrayListOf("Apple", "Orange", "Cucumber") // Array List selalu mutable
    val emptyMutableList: List<Int> = mutableListOf()

    // Properties and Method in Kotlin
    val users = mutableListOf("Andy", "Gary", "Patrick")

    if (users.isEmpty()){ // isEmpty() is a method
        println("List is empty. Sorry")
    } else {
        println("List is not empty. Continue")
    }

    if (users.size > 5){ // size is a properties
        println("Continue")
    } else {
        println("Sorry")
    }

    println(users.first()) // first() is a method
    println(users.last()) // first() is a method

    // println(users.min()) DEPRECATED
    // println(users.max()) DEPRECATED

    val userAge = listOf(11, 22, 33)

    // println(userAge.min()) DEPRECATED
    // println(userAge.max()) DEPRECATED

    // Indexing
    val animals = arrayOf("Lions", "Tiger", "Leopard", "Frog", "Cat", "Dolphin", "Fox")

    println(animals[2])

    // Join To String
    println(animals.joinToString())

    // Slice by Ranges
    val firstTwoAnimal = animals.slice(0..1)
    println(firstTwoAnimal.joinToString())

    val nextTwoAnimal = animals.slice(2..3)
    println(nextTwoAnimal.joinToString())

    // Checking for an Array Element
    println(isAnimalRemoved("Tiger", animals)) // Using function
    println(doesAnimalExist("Tiger", animals))

    if (animals.contains("Lions")){  // Using contains
        println("Lions exist")
    } else {
        println("Lions doesn't exist")
    }

    if (animals.slice(1..3).contains("Frog")){ // Using contains with slice
        println("Frog does exist")
    } else {
        println("Frog does not exist")
    }

    // Appending Elements
    val fruits = mutableListOf("Strawberry", "Melon", "Apple", "Orange", "Watermelon", "Banana")

    fruits.add("Cucumber") // ADD elements to list
    println(fruits.last())

    fruits += "Durian"  // menggunakan operator +=
    println(fruits.last())
    println(fruits.joinToString())

    var evenNumber1 = arrayOf(2, 4, 6, 8) // harus menggunakan variable (var) bukan constant (val)
    println(evenNumber1.joinToString())

    evenNumber1 += 10 // sebenarnya bukan menambahkan value kedalam array yang ada, tetapi membuat array baru dalam variable yang ada
    println(evenNumber1.joinToString())

    // Inserting Elements
    fruits.add(2, "Srikaya")    // menggunakan add(idx, elm)
    println(fruits.get(2))
    println(fruits.joinToString())

    // Removing Elements
    fruits.remove("Melon")  // mennggunakan remove
    println(fruits.joinToString())

    var melonRemoved = fruits.remove("Watermelon")
    println(melonRemoved)
    println(fruits.joinToString())

    fruits.removeAt(0)  // menggunakan removeAt
    println(fruits.joinToString())

    var fruitIndex1 = fruits.removeAt(1)
    println(fruits.joinToString())
    println("$fruitIndex1 is removed from list")

    // Updating Elements
    fruits.set(0, "Pineapple")  // menggunakan SET
    println(fruits.joinToString())

    fruits[1] = "Cranberrys"    // menggunakan index, untuk mengupdate ARRAY bisa pake index
    println(fruits.joinToString())

    fruits.sort()   // akan diurutkan sesuai abjad, menggunakan SORT
    println(fruits.joinToString())

    // Iterating over a List
    for (fruit in fruits){  // gapake index
        println(fruit)
    }
    for ((index, fruit) in fruits.withIndex()) {    // dengan index
        println("$index, $fruit")
    }

    println(sumResult(userAge)) // menggunakan function

    // Nullability and Collection types
    var seaAnimal : List<String>? = mutableListOf("Dolphin", "Whale", "Shark")     // Nullable List
    seaAnimal = null

    var landAnimal : List<String?> = mutableListOf("Elephant", null, "Deer")     // Nullable Elements

    var airAnimal : List<String?>? = mutableListOf("Hawk", "Eagle", null)       // Nullable List and Elements
    airAnimal = null


}

// Checking for an Array Element
fun isAnimalRemoved(animal: String, array: Array<String>) : Boolean {
    return (animal !in array)
}
fun doesAnimalExist(animal: String, array: Array<String>) : Boolean {
    return animal in array
}

// Iterating over a List
fun sumResult(numbers: List<Int>) : Int{
    var result = 0

    for (number in numbers){
        result += number
    }
    return result
}