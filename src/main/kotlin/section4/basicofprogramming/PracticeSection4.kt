package section4.basicofprogramming

const val myName: String = "Adelia Ayu Trilestari"
//const val myNickname: String  error karena wajib di initialized

fun main() {
    println(5 / 2)

    // This is shift operation left, so in binary its shifted to the left by 2
    println(25 shl 2)

    // This is shift operation right, so in binary its shifted to the right by 2
    println(37 shr 2)

    val myLuckyNumber: Int //Tidak perlu inisialisasi langsung
    // type val tidak bisa diganti isinya
    val myPiNumber: Double = 3.14
    println(myPiNumber)

    val priceNumber: Float = 2.1F
    println(priceNumber)

    var myAge: Int = 24
    println(myAge)
    myAge = 25
    println(myAge)

    var myBankAcc: Int = 1_000_000
    println(myBankAcc)

    myAge += 25
    println(myAge)

    myAge -= 25
    println(myAge)

    myAge--
    println(myAge)
}

/*Shift operation in programming shifted its decimal number in binary then turn it back to decimal number
shifted left by 1 means dikali 2
shifted left by 2 means dikali 4

shifted right by 1 means dibagi 2
shifted right by 2 means dibagi 4
 */

/*
This is a comment

Multiline comment is here
 */

//This is also a comment
