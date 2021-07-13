package section8.functions

/*
    1. Create 5 basic functions
    2. Create 5 parameterized functions
    3. Create 5 parameterized functions that return values
    4. Create 5 functions with the same name
    5. Create 5 functions and assign them to 5 constants
 */

fun main(){
    //5
    var rerata2Nilai = ::averageNumber
    var coba = averageNumber(5,4)
    println(rerata2Nilai(8,4))
    println(coba)
    var nilaiTerkecil = ::minNumber
    var lolosKKM = ::validasiScore
    var butuhOksigen = ::cekOksidasi
    var tesAntigen = ::cekCovid

    challenge1(::averageNumber,::minNumber, 10, 20)
}

fun challenge1(rerata2Nilai: (Int, Int) -> Int, nilaiTerkecil: (Int, Int) -> Int, firstNumber: Int, secondNumber: Int){
    println(rerata2Nilai(firstNumber, secondNumber))
    println(nilaiTerkecil(firstNumber, secondNumber))
}

//1
fun printHelloWorld(){
    println("Hello World!")
}
fun printYourCarBrand(){
    println("My car is Toyota Kijang")
}
fun printNumbers(){
    for (i in 1..5){
        println("Nomor $i")
    }
}
fun printYourFavFood(){
    println("Saya suka bakso")
}
fun printAlarm(){
    println("Kring.. kring..")
}

//2
fun multiply(firstNumber: Int, secondNumber: Int){
    println("$firstNumber x $secondNumber = ${firstNumber * secondNumber}")
}

fun dividi(firstNumber: Int, secondNumber: Int){
    println("$firstNumber / $secondNumber = ${firstNumber / secondNumber}")
}

fun add(firstNumber: Int, secondNumber: Int){
    println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
}

fun substract(firstNumber: Int, secondNumber: Int){
    println("$firstNumber - $secondNumber = ${firstNumber - secondNumber}")
}

fun square(firstNumber: Int){
    println("$firstNumber pangkat 2 = ${firstNumber * firstNumber}")
}

//3
fun hasilPerkalian(firstNumber: Int, secondNumber: Int) = firstNumber * secondNumber

fun hasilPembagian(firstNumber: Int, secondNumber: Int) : Int {
    return firstNumber / secondNumber
}

fun mixed2Words(firstWord: String, secondWord: String) : String {
    return "Kata sambung pertama $firstWord dan kedua $secondWord"
}

fun perkalianDanPembagian(firstNumber: Int, secondNumber: Int): Pair<Int, Int> {
    return Pair(firstNumber*secondNumber, firstNumber/secondNumber)
}

fun penjumlahanPenguranganDanPerpangkatan(firstNumber: Int, secondNumber: Int) : Triple<Int,Int,Int> {
    return Triple(firstNumber+secondNumber, firstNumber-secondNumber, firstNumber*firstNumber)
}

//4
fun operasiMatematika(firstNumber: Int, secondNumber: Int): Int = firstNumber + secondNumber
fun operasiMatematika(firstNumber: Double, secondNumber: Double): Double = firstNumber * secondNumber
fun operasiMatematika(firstNumber: Float, secondNumber: Float): Float = firstNumber / secondNumber
fun operasiMatematika(firstNumber: Int, secondNumber: Int, thirdNumber: Int): Int = firstNumber - secondNumber - thirdNumber
fun operasiMatematika(firstNumber: Int): Int = firstNumber * firstNumber

//5
fun averageNumber(firstNumber: Int, secondNumber: Int) = (firstNumber + secondNumber) / 2

fun minNumber(firstNumber: Int, secondNumber: Int) : Int {
    var result: Int
    when {
        firstNumber < secondNumber -> result = firstNumber
        else -> result = secondNumber
    }
    return result
}
fun validasiScore(number: Int) : String {
    var result = when (number) {
        in 1..75 -> "Dibawah KKM"
        in 75..100 -> "Diatas KKM"
        else -> "Nilai tidak valid"
    }
    return result
}
fun cekOksidasi(number: Int) : String {
    var result = when (number) {
        in 95..100 -> "Tidak perlu tabung oksigen"
        else -> "Perlu tabung oksigen"
    }
    return result
}
fun cekCovid(hasilTes: String) : Boolean {
    var result = when (hasilTes) {
        "reaktif" -> true
        else -> false
    }
    return result
}
