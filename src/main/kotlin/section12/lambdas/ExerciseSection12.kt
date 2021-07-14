package section12.lambdas

import java.lang.Exception

/*
    1. Create 10 Lambda Expressions
    2. Use the Shorthand Syntax
    3. Create 5 Lambda Expressions with one parameter (it)
    4. Use 2 Lambda Expressions as Arguments
    5. Create 3 Lambda Expressions with meaningless return value
    6. Sort 2 arrays using Lambdas
    7. Create 5 collection and iterate over them using Lambdas
 */

fun main() {
    //1
    val lambda1: (Int, Int) -> Int
    lambda1 = { first: Int, second:Int -> Int
        first + second }
    println(lambda1(5,2))

    val lambda2: (Double, Double) -> Double
    lambda2 = { first, second -> first / second }
    println(lambda2(43.2 , 2.0))

    val lambda3: (Int) -> String = { grade -> if (grade > 5) "Good Job" else "Bad Job" }
    println(lambda3(6))

    val lambda4 = { first: Float -> Float
        first * 4F }
    println(lambda4(5.2F))

    val lambda5: (Int, Int) -> Unit = { first, second -> println("Nomor $first mendapat $second gelas") }
    lambda5(1, 5)

    val lambda6: () -> Unit = { println("Syalala") }
    lambda6()

    val lambda7: (String) -> Unit = { name -> println("Nama saya adalah $name") }
    lambda7("Syahdu")

    val lambda8: (Double) -> String = { ipk -> if (ipk > 3.5) "Cum Laude" else "Not Cum Laude" }
    println(lambda8(2.4))

    val lambda9: (Int) -> Int = { number -> number * 4 }
    println(lambda9(9))

    val lambda10: (Char) -> Unit = { nilai -> println("Saya mendapatkan nilai $nilai") }
    lambda10('B')

    //2
    val shortLambda: (Int) -> Int = { number -> number * number }
    println(shortLambda(6))

    //3
    val itLambda1: (Int) -> Int = { it + 10 }
    println(itLambda1(6))

    val itLambda2: (String) -> Unit = { println("Name saya adalah $it") }
    itLambda2("Jono")

    val itLambda3: (Double) -> Char = { if (it.equals(4.0)) 'A' else 'B' }
    println(itLambda3(2.3))

    val itLambda4: (Char) -> String = { if (it.equals('A')) "Kerja bagus" else "Tingkatkan lagi" }
    println(itLambda4('B'))

    val itLambda5: (Double) -> Unit = { println("IPK saya semester ini adalah $it") }
    itLambda5(4.0)

    //4
    val plus = { fn: Int, sn: Int -> fn + sn }
    val result = (add2Number(5, 2, plus))
    println("Hasil penjumalahan adalah $result")

    val nilai = { nilai: Int -> if (nilai >= 75) "Diatas KKM" else "Dibawah KKM"}
    convert(65, nilai)

    //5
    val lambdaUnit = { fruit: String -> println("Buah favorite saya adalah $fruit") }
    lambdaUnit("Apple")
    val lambdaUnit1: () -> Unit = { println("Saya suka memasak") }
    lambdaUnit1()
//    val lambdaNothing: () -> Nothing = { throw ArrayIndexOutOfBoundsException()}
//    lambdaNothing()

    //6
    val numbers = arrayOf(5, 2, 6, 3, 8, 2, 9)
    println(numbers.sorted())

    val fruits = arrayOf("Apple", "Peach", "Grape", "Poison")
    var sortedFruit = fruits.sortedWith(compareBy({
        it.length
    }))
    println(sortedFruit)

    //7
    val randomNumber = arrayOf(5, 23, 65, 23, 7, 3, 542)

    println(randomNumber.filter { it > 10 })
    println(randomNumber.filterNot { it < 90 })
    println(randomNumber.map { it * 14 })
    println(randomNumber.map { it.toString() })
    println(randomNumber.reduce { fn, sn -> fn + sn })


}

fun add2Number(first: Int, second: Int, lambda: (Int, Int) -> Int) : Int {
    return lambda(first, second)
}

fun convert(grade: Int, lambda: (Int) -> String){
    println(lambda(grade))
}