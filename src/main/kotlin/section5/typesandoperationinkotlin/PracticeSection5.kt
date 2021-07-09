package section5.typesandoperationinkotlin

fun main() {

    // Bisa dicast ke types yang berbeda menggunakan type conversion toInt() atau toDouble()
    var myIntNumber: Int = 10
    println(myIntNumber)

    var myDecimalNumber: Double = 15.7
    println(myDecimalNumber)

    myIntNumber = myDecimalNumber.toInt()
    println(myIntNumber)

    // Otomatis punchPower Int akan dikonversi ke Double tanpa menggunakan toDouble()
    var punchPower: Int = 20
    var punchSpeed: Double = 48.7
    var overallPerformance: Double = punchPower * punchSpeed
    println(overallPerformance)

    // Type inference adalah variable yang di deklarasi tanpa type, untuk mengetahui type nya ctrl+shift+p
    var computerRam = 16.0.toInt()
    println(computerRam)

    // Representing Character
    val letterA = 'a'
    println(letterA)

    // Representing String
    val myNames = "Adelia Ayu"
    println(myNames)

    // Concatenation
    var myProfession: String = "I " + "am " + "a " + "Programmer"
    println(myProfession)

    var myName = "Adelia"
    var myJob = " is a Programmer"
    // myName = myName + myJob
    myName += myJob
    println(myName)

    myName += '!'
    println(myName)

    // String templates
    var myAge = 25
    var message = "I am $myAge years old"
    println(message)
    var addition = "2 + 2 is = ${2 + 2}"
    println(addition)

    // Multilines String
    var myHobbies = """
        Gaming
        Running
        Programming
    """.trimIndent()
    println(myHobbies)

    // Pairs
    //val xAndY: Pair<Int, Int> = Pair(10, 20)
    val xAndY = Pair(10, 20)
    println(xAndY.first)
    println(xAndY.second)

    val xAndYWithTo = 10 to 20
    println(xAndYWithTo.first)
    println(xAndYWithTo.second)

    val mixedPair = 3.2 to 7
    val (x, y) = mixedPair
    println(x)
    println(y)

    // Triple
    val xyz: Triple<Int, Double, Float> = Triple(12, 3.5, 2.3F)
    println(xyz.first)
    println(xyz.second)
    println(xyz.third)

    val (x2, y2, z2) = xyz
    println(x2)
    println(y2)
    println(z2)

    // Numeric types in kotlin
    val byteNumber: Byte = 127
    val shortNumber: Short = 32000
    val intNumber: Int = 20_000_000
    val longNumber: Long = 2394000320001

    val intResult = byteNumber + shortNumber + intNumber + longNumber
    println(intResult)

    val floatNumber: Float = 3.6F
    val doubleNumber: Double = 33.43434

    val decimalNumber = floatNumber + doubleNumber
    println(decimalNumber)

    // Any, Unit, Nothing
    /* Any = Mothers of all types
       Unit = Returns nothing, does the work
       Nothing = Returns nothing, never completes
     */
    val intNumbers: Any = 100
    val stringValue: Any = "Adelia"

    println(intNumbers)
    println(stringValue)
}