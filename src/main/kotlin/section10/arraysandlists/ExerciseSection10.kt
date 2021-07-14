package section10.arraysandlists

/*
    1. Create 5 Integer Arrays
    2. Create 5 String Arrays
    3. Convert Integer Array to Primitive
    4. Create 5 Double Lists
    5. Create 5 Mutable Lists
    6. Access the elements of lists
    7. Use properties and methods
    8. Use indexing
    9. Use ranges to slice lists
    10. Check for an element using in
    11. Append elements to list
    12. Insert an element into list
    13. Remove elements from list
    14. Update list elements
    15. Iterate through list
    16. Create 3 nullable collections
 */

fun main(){
    //1
    var evenNumber = intArrayOf(2, 4, 6, 8)
    var oddNumber: IntArray = intArrayOf(1, 3, 5, 7)
    var number1to5: IntArray = intArrayOf(1,2,3,4,5)
    var defaultNumber2 = IntArray(5, {2})
    var zeroNumbers = IntArray(4)

    //2
    var cars = arrayOf("Toyota", "Avanza", "Agya")
    var motorcycle = arrayOf("Nex", "Beat", "Vario")
    var fruits = Array(5, {"Fruits"})
    var rujak: Array<String> = arrayOf("Apel", "Mangga", "Timun")
    var handphone: Array<String> = arrayOf("Samsung", "iPhone", "Xiaomi")

    if (cars.contains("Toyota")){
        println("Benar ada")
    } else {
        println("Tidak ada")
    }

    //3
    var number1to10 = arrayOf(1,2,3,4,5,6,7,8,9,10).toIntArray()

    //4
    var evenDoubleNumber = listOf(2.6, 4.4, 8.6)
    var oddDoubleNumber: List<Double> = listOf(5.3, 1.5, 7.9)
    var randomNumbers: List<Double> = listOf(6.4, 8.0, 5.2)
    var emptyDoubleList: List<Double> = listOf()
    var emptyDoubleList1 = listOf<Double>()
    var number1toRandom = listOf<Double>(1.0, 2.0, 3.0)

    //5
    var nameList = mutableListOf("Ahmad", "Doni", "Budi", "Tony", "Karin", "Ani")
    var gradeList: List<Int> = mutableListOf(4, 6, 9, 8)
    var floatList: List<Float> = mutableListOf(5.6F, 3.7F, 44.5F)
    var trueAndFalseList: List<Boolean> = mutableListOf(true, false, false)
    var convertedMutableList: List<Int> = listOf(4, 6, 7, 5).toMutableList()

    println(nameList.filterNot {
        it.uppercase().contains('A')
   //     it.contains('A') || it.contains('a')
    })


    //6
    println(nameList.get(0))
    println(gradeList.first())
    println(floatList.last())

    //7
    println(trueAndFalseList.isEmpty())
    println(convertedMutableList.size)
    println(number1toRandom.lastIndex)
    println(randomNumbers.indexOf(8.0))

    //8
    println(nameList[1])
    println(gradeList[0])
    println(randomNumbers[2])

    //9
    var firstTwoNames = nameList.slice(0..1)
    println(firstTwoNames)
    var nextThreeNames = nameList.slice(2..4)
    println(nextThreeNames.joinToString())

    //10
    doesThisElementExist("Ahmad", nameList)

    //11
    nameList.add("Bella")
    println(nameList.joinToString())
    nameList += "Valcon"
    println(nameList.joinToString())

    //12
    nameList.add(3, "Tomoko")
    println(nameList.joinToString())

    //13
    nameList.removeAt(5)
    println(nameList.joinToString())
    nameList.remove("Bella")
    println(nameList.joinToString())

    //14
    nameList.set(3, "Jono")
    println(nameList.joinToString())
    nameList[0] = "Argon"
    println(nameList.joinToString())

    //15
    for (name in nameList){
        println(name)
    }
    for ((index,element) in gradeList.withIndex()){
        println("Pada indeks ke $index berisi $element")
    }

    //16
    var grade : Array<Int?> = arrayOf(4, null, 5, 8, 3)
    println(grade.joinToString())

    var age : List<Int>? = mutableListOf(7, 8, 34, 33)
    println(age?.joinToString())
    age = null
    println(age)

    var car : List<String?>? = mutableListOf("Agya", "Ignis", "Inova", null)
    println(car?.joinToString())
}

// 10
fun doesThisElementExist(name: String, array: MutableList<String>) : Boolean{
    return (name in array)
}