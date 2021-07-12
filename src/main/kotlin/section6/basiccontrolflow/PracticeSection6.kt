package section6.basiccontrolflow

fun main() {

    // Boolean Operators boolean: true, false operators: !,==,>,<,>=,<=

    var thisIsTrue = true
    var thisIsNotTrue = !thisIsTrue
    println(thisIsTrue)
    println(thisIsNotTrue)

    var is2GreaterThan4 = (2 > 4)
    println(is2GreaterThan4)

    // Boolean Logic AND (&&) dan OR (||)

    var age = 20
    var isUserSingle = true

    var datingResult: Boolean = (age > 18) && (isUserSingle == true)
    println(datingResult)

    age = 15
    isUserSingle = false
    datingResult = (age > 18) || (isUserSingle == true)
    println(datingResult)

    // String Equality
    // Boolean operator jika digunakan untuk string hanya akan membandingkan manakah string diposisi lebih dulu

    var hp1 = "iPhone"
    var hp2 = "iPhone"
    var stringResult = ("a" < "b")
    println(stringResult)
    stringResult = (hp1 == hp2)
    println(stringResult)

    // IF Expression

    var age1 = 20
    var isUserSingle1 = false

    if (age1 > 18) println("Sign up")

    if (age1 > 18 && isUserSingle1 == true) {
        println("Sign Up")
    } else {
        println("You're not qualified")
    }

    var myScore = 64
    if (myScore >= 10 && myScore < 20) {
        println("Bad Score")
    } else if (myScore >= 20) {
        println("Not bad")
    } else if (myScore >= 30) {
        println("Good")
    } else {
        println("Unknown Score")
    }

    // Short Circuiting
    /* Ketika kondisi pada if expression menggunakan boolean logic AND dan statement pertama FALSE, maka hasil FALSE dan statement selanjutnya tidak akan dicek
        Ketika menggunakan boolean logic OR dan statement pertama TRUE, maka hasil TRUE dan statement selanjutnya tidak akan dicek
     */

    if ( 10 < 2 && 5 < 10 ){
        println("Tidak tercetak")
    } else {
        println("Statement 10 < 2 saja yang akan dicek karna AND dan FALSE")
    }

    if ( 5 != 3 || 10 > 2 ){
        println("Statement 5 != 3 saja yang akan dicek karna OR dan TRUE")
    } else {
        println("Tidak tercetak")
    }

    // Encapsulating Variables

    var power = 100
    var speed = 8

    if (power > 90 && speed > 7) {
        var combination = power * speed
        println(combination)
    }
    // println(combination)
    // ERROR Karena combination tidak dapat diakses diluar SCOPE IF

    // LOOPS
    // While Loops

    var counter = 0

    while (counter < 10) {
        println("Hello! - $counter")
        counter++
    }

    // Do-While Loops
    counter = 0

    do {
        println("Hi!")
        counter++
    } while (counter < 0)

    // Breaking out of loop
    while (true) {
        println("Hola")
        break
    }

    counter =  0

    while (true) {
        println("Hiya! - $counter")
        counter++

        if (counter == 10){
            println("Stop Hiya!")
            break
        }
    }
}