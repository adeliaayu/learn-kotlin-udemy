package section12.lambdas


fun main(){
    // Lambda
    /*
        1. Reusable Code -> easier to write and understand rather than function
        2. No name -> actually function without names
        3. Assign -> can be assigned to variable
        4. Get, hold and modify
     */

    // Creating Lambda
    var addLambdaFunction : (Int, Int) -> Int

    addLambdaFunction = { firstNumber: Int, secondNumber: Int -> Int

        firstNumber * secondNumber
        firstNumber + secondNumber          // Always return the last line of code
    }

    println(addLambdaFunction(2, 9))        // Akan jadi 11 karena last line adalah penjumlahan

    // Lambda Shorthand Syntax
    var timesLambdaFunction: (Int, Int) -> Int

    timesLambdaFunction = { firstNumber, secondNumber -> firstNumber * secondNumber }

    var result = timesLambdaFunction(5, 6)
    println(result)

    // It keyword in lambdas
    var multiplyBy5 = { number: Int -> Int
        number * 5
    }

    multiplyBy5 = { it * 5 }        // it akan menggantikan parameter number, kedua lambda ini memiliki arti yang sama

    result = multiplyBy5(7)
    println(result)

    var multiplyBy10: (Int) -> Int = { it * 10 }        // proses ini sama fungsinya seperti diatas

    result = multiplyBy10(9)
    println(result)

    // Lambda as Arguments
    var multiply2Number = { fn: Int, sn: Int -> fn * sn }

    var multiplyResult = multiply( 5, 2, multiply2Number)       // passing lambda as arguments for other function
    println(multiplyResult)

    multiplyResult = multiply(6, 8, { first, second -> first * second })    // bisa tulis langsung lambdanya
    println(multiplyResult)

    // Trailing Lambda Syntax
    multiplyResult = multiply(98, 34) { first, second -> first * second }   // apabila sebagai paramater terakhir, lambda dapat ditulis diluar dalam kurung parameter
    println(multiplyResult)

    // Function as Arguments
    multiplyResult = multiply(5, 3, ::multiplyFunction)         // passing function as arguments for other function
    println(multiplyResult)                                            // Reference Operator (::) digunakan oleh func multiply untuk mencari func multiplyFunction

    // Meaningless Return Value
    var playFootball: () -> Unit = {        // Return value Unit means does something, no return value
        println("Playing football")         // tanda kurung kosong menandakan tidak ada parameter
    }
    playFootball()          // tanda kurung akan menandakan kita memanggil func/lambda nya, bukan variable nya
    playFootball            // tidak akan tercetak playing football

    // Nothing Return Value
    var nothingReturned: () -> Nothing = {          // Means return literally nothing, do nothing and throw an exception
        throw ArrayIndexOutOfBoundsException()      // Use nothing type to intentionally crash the app
    }
    // nothingReturned()

    // Capturing Lambda Expression
    var oneNumber = 6

    var multiplyBy2 = { oneNumber *= 2 }        // Dia capture variable diluar kemudian diproses dengan lambda expression

    multiplyBy2()
    println(oneNumber)

    multiplyBy2()
    println(oneNumber)

    var firstMultiply = multiplyMyNumberBy5()
    var secondMultiply = multiplyMyNumberBy5()

    println(firstMultiply)
    println(firstMultiply())
    println(firstMultiply())

    println(secondMultiply())
    println(secondMultiply())

    // Lambda Sorting
    val alphabetArray = arrayOf('R', 'D', 'G', 'A', 'C')
    println(alphabetArray.joinToString())

    println(alphabetArray.sorted())         // Sorting using sorted

    // Sorting dengan menggunakan kriteria kita sendiri
    val brands = arrayOf("Xiaomi", "Sony", "Samsung", "Apple", "LG")
    println(brands.joinToString())

    var sortedBrands = brands.sortedWith(compareBy({
        it.length
    }))
    println(sortedBrands)

    sortedBrands = brands.sortedWith(compareBy({
        -it.length
    }))
    println(sortedBrands)

    // Lambda Iteration Pada Arrays dan Map
    brands.forEach {        // melakukan pengulangan sebanyak ukuran array, untuk setiap isi dari array
        println(it)
    }

    val ages = arrayOf(5, 2, 55, 12, 64, 27, 39, 18)
    println(ages.filter { it >= 18 })               // menyaring / FILTER sesuai kondisi yang diberikan

    println(brands.filter { it.uppercase().contains('A') })

    val oddNumber = arrayOf(1, 3, 5, 7, 9, 11, 13)
    val evenNumber = oddNumber.map { it * 2 }       // melakukan perkalian 2 untuk setiap isian array
    println(evenNumber.joinToString())

    println(evenNumber.map { it.toDouble() })       // mengubah tipe data menjadi double

    println(brands.map { "Brand " + it })           // menambahkan kata kedalam isian array String

    val randomWords = arrayOf("Apple", "54", "Brand", "42")
    println(randomWords.map { it.toIntOrNull() })               // apabila tidak bisa jadi INT maka akan menjadi NULL

    println(randomWords.mapNotNull { it.toIntOrNull() })        // menghilangkan nilai Null dari hasil lambda

    val randomNumbers = arrayOf(3, 5, 8, 6, 12)
    var resultNumber = randomNumbers.fold(0, { initial, arrayNumber -> initial + arrayNumber })     // SUM menggunakan FOLD
    println(resultNumber)

    resultNumber = randomNumbers.reduce({ firstNumber, secondNumber -> firstNumber + secondNumber })      // SUM menggunakan REDUCE
    println(resultNumber)

    // Lambda Iteration on Maps

    val personAges = mapOf("Jack" to 34, "Andy" to 63, "Kellin" to 28, "Karen" to 22)

    personAges.forEach {
        println("Umur ${it.key} adalah ${it.value}")
    }
}

// Lambda as Arguments
fun multiply( fn: Int, sn: Int, multiplyFunction: (Int, Int) -> Int) : Int{

    var result = multiplyFunction(fn, sn)

    return result
}

// Function as Arguments
fun multiplyFunction( fn: Int, sn: Int ) : Int{
    return fn * sn
}

// Capturing Lambda Expression
fun multiplyMyNumberBy5() : () -> Int {
    var myNumber = 2

    var myLambda: () -> Int =  {
        myNumber *= 5
        myNumber
    }

    return myLambda
}
