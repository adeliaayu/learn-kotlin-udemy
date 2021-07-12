package section8.functions

fun main() {
    // Functions
    printHobbies()

    // Parameterized Functions
    printHobbiesEntry("Kayaking, Running")
    multipleBy9(53)

    // Parameterized Functions with multiple parameter
    multiple2Numbers(8,3)
    multiple2Numbers(secondNumber = 6, firstNumber = 5)

    // Parameterized Functions with default value
    divide2Numbers(secondNumber = 5)
    divide2Numbers()

    // Functions with returned Value
    var returnedValue = sum2Numbers(8,5)
    println(returnedValue)
    println("${sum2Numbers(90,6)}")

    // Functions with more than 1 returned Value
    var (addResult, subsResult) = addAndSubstract(30,50)
    println("$addResult, $subsResult")

    // Functions with returned Value and 1 expression
    println(add2Numbers(20,50))

    // Parameters as Constants
    multiply(9)

    // Function Overloading
    println(multiplyBy2(5))
    println(multiplyBy2(5.4))
    println(multiplyBy2(6.4,2.0))

    // Function as Variables
    var multiplyFun = ::multiple // variable multiplyFun memiliki tipe data function (int, int) -> int
    println(multiplyFun(6,3))
                                // :: disebut method reference operator
    multiplyFun = ::divide
    println(multiplyFun(6,3))
    // seperti pada umumnya, variable dapat di reassign dengan syarat jumlah dan tipe data dari parameter dan return value function harus sama
    /* (int, int) -> int dan (int, int) -> int bisa
     (int, int) -> int dan (int) -> int tidak bisa
     (int, int) -> int dan (int, int) -> double tidak bisa
     (int, int) -> int dan (int, double) -> int tidak bisa
    */

    // Function as Variable also can be parameters to a function #crzy #mndblwng
    printMultiplyResult(::multiple, 5, 10)
    printMultiplyResult(::divide, 100, 5)

    // Lack of Returns
    /* #use nothing type to crash the process so user try again : with condition named event loop that returns nothing
    Kenapa digunakan? Untuk optimasi proses sehingga app tidak menunggu adanya return value
     */

    // Function writing tips
    /*
    1. Short and meaningful
    2. One task, One Function
    3. Well-defined parameters
     */
}

// Functions
fun printHobbies(){
    println("Gaming, Watching Movies, Reading Books")
}

// Parameterized Functions
fun printHobbiesEntry(hobby: String){
    println(hobby)
}

fun multipleBy9(number: Int){
    println("$number * 9 = ${number * 9}")
}

// Parameterized Functions with multiple parameter
fun multiple2Numbers(firstNumber: Int, secondNumber: Int){
    println("$firstNumber * $secondNumber = ${firstNumber * secondNumber}")
}

// Parameterized Functions with default value
fun divide2Numbers(firstNumber: Int = 100, secondNumber: Int = 4){
    println("$firstNumber / $secondNumber = ${firstNumber / secondNumber}")
}

// Functions with returned Value
fun sum2Numbers(firstNumber: Int, secondNumber: Int) : Int {
    return firstNumber + secondNumber
}

// Functions with more than 1 returned Value
fun addAndSubstract(firstNumber: Int, secondNumber: Int) : Pair<Int,Int> {
    return Pair(firstNumber + secondNumber, firstNumber - secondNumber)
}

// Functions with returned Value and 1 expression
fun add2Numbers(firstNumber: Int, secondNumber: Int) = firstNumber + secondNumber

// Parameters as Constants
fun multiply(number: Int){
    // number *= 2 ERROR karena parameter adalah konstanta yang tidak bisa diubah valuenya
    var newNumber = number * 2
    println(newNumber)  // bisa jalan karena memindahkan value kedalam variable baru dan tidak mengubah konstanta
}

// Function Overloading : Berbeda tipe data parameter atau berbeda jumlah parameter
fun multiplyBy2(number: Int) : Double {
    return number.toDouble() * 2
}

fun multiplyBy2(number: Double) : Double {
    return number * 2
}

fun multiplyBy2(number: Double, secondNumber: Double) : Double {
    return number * secondNumber
}

// Function as Variables
fun multiple(firstNumber: Int, secondNumber: Int) : Int {
    return firstNumber * secondNumber
}

fun divide(firstNumber: Int, secondNumber: Int) : Int {
    return firstNumber / secondNumber
}

// Function as Variable also can be parameters to a function #crzy #mndblwng
fun printMultiplyResult(myFunction: (Int, Int) -> Int, firstNumber: Int, secondNumber: Int){
    val multiplyResult = myFunction(firstNumber, secondNumber)
    println(multiplyResult)
}