package section7.advancedcontrolflow

fun main(){
    // Closed Range
    val myClosedRange: IntRange = 0..10 // 0,1,2,3,4,5,6,7,8,9,10 printed 0..10

    // Half Open Range
    val myHalfOpenRange: IntRange = 0 until 10 // 0,1,2,3,4,5,6,7,8,9 printed 0..9

    // Decreasing Range
    val decreasingRange: IntProgression = 10 downTo 0 // 10,9,8,7,6,5,4,3,2,1,0 printed 10 downTo 0 step 1

    println(myClosedRange)
    println(myHalfOpenRange)
    println(decreasingRange)

    // For Loops
    // Using Closed range
    var multiplyResult = 1
    for (i in 1..5){
        multiplyResult *= 2
    }
    println(multiplyResult)
    /*
    1 1
    2 4
    3 8
    4 16
    5 32
     */

    // Using Half Open range
    multiplyResult = 1
    for (i in 1 until 5) {
        multiplyResult *= 2
    }
    println(multiplyResult)
    /*
   1 1
   2 4
   3 8
   4 16
    */

    // Repeat
    repeat(5){
        println("Hello!")
    }

    multiplyResult = 1
    for (i in 1..10 step 2){
        multiplyResult *= 2
        println(i)
    }
    println(multiplyResult)
    /*
    1 1
    3 4
    5 8
    7 16
    9 32
     */

    // For dengan decreasing range
    for (i in 10 downTo 0 step 2){ // 10, 8, 6, 4, 2, 0
        println(i)
    }

    // Labeled Statements
    for (i in 1..10){
        if (i % 2 == 0){
            continue  // Kembali ke for apabila kondisi If terpenuhi atau benar, berbeda dengan break yang langsung menghentikan proses
        }
        println(i)
    }

    // Nested For dan Labeled Statements
    // Digunakan untuk menandai statement contohnya row dibawah ini, untuk menghentikan loop dapat digunakan break@loop yang diinginkan
    loopForRows@ for (row in 0 until 3){
        println(row)

        loopForColumn@ for (column in 0 until 2){
            if (column == 0){
                break@loopForRows
            }
            println(column)
        }
    }

    // When Expression
    var age = 20
    when (age) {
        20 -> println("You're qualified")
        else -> println("You're not qualified")
    }

    var myComputer = "Macbook"
    when (myComputer){
        "Macbook", "PC" -> println("My computer is Macbook or PC")
    }

    // Returning Values in When Expression

    var grade = 20
    var description = when (grade){
        10 -> "Bad grade"
        20 -> {
            println("The grade is 20")
            "Not bad"
        }
        30 -> "Good"
        else -> "Unknown"
    }
    println(description)

    // Advanced When Expression
    grade = 40
    description = when (grade) {
        in 1..10 -> "Bad grade"
        in 11..20 -> "Not Bad"
        in 21..30 -> "Good"
        in 31..40 -> "Great"
        else -> "Invalid Grade"
    }

    var score = 20
    when {
        score % 2 == 0 && score > 10 -> println("This score is even and more than 10")
        else -> println("This number is odd number")
    }

}