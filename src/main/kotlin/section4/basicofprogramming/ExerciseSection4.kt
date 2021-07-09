package section4.basicofprogramming

/*
    1. Buat constant dengan type Int kemudian inisialisasi, gunakan real-world constant
    2. Calculate average of 2 numbers
    3. Buat variable dengan type Int dengan value apapun kemudian lakukan operasi sebagai berikut
        a. number +2 -10 *9 /4 shr3 +1 *2 shl4
     */

fun main () {
    //1
    val myComputerRAM: Int = 12
    //2
    val numbers = listOf(10,20)
    println(numbers.average())
    //3
    var number: Int = 10
    number += 2
    println(number)
    number -= 10
    println(number)
    number *= 9
    println(number)
    number /= 4
    println(number)
    number = number shr 3
    println(number)
    number++
    println(number)
    number *= 2
    println(number)
    number = number shl 4
    println(number)
}
