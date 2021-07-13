package section9.nullability

import com.sun.org.apache.xpath.internal.operations.Bool

/*
    1. Create 10 nullable variables
    2. Use not null assertion operator
    3. Use safe calls
    4. Use the let function
    5. Use the elvis operator
 */

fun main(){
    //1
    var myName: String?
    var myAge: Int?
    var myGrade: Double?
    var myScore: Float?
    var isTrue: Boolean?
    var myInitial: Char?
    var bunchOfNumbers: IntRange?
    var bunchOfDecreasingNumber: IntProgression?
    var myCatName: String?
    var myGlassesBrand: String?

    //2
    var myFavoriteNumber: Int? = null
    //println("Angka favorite saya dikali 2 = ${myFavoriteNumber!! * 2}" )
    println("Angka favorite saya dikali 2 = ${myFavoriteNumber?.times(2) ?: 0}" )

    //3
    var myNickname: String? = "Adel"
    println("Jumlah karakter nama panggilan saya ada ${myNickname?.length}")

    //4
    var myIPK: Double? = null
    myIPK?.let {
        println("Nilai IPK anda telah muncul yakni $myIPK")
    } ?: run {
        println("Tercetak kalo let tidak jalan")
    }

    //5
    var myUniqueId: Int? = null
    println("Nomor ID saya adalah ${myUniqueId ?: 0}")
    
}