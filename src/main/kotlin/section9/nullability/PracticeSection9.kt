package section9.nullability

fun main(){

    // Introduction to Nulable Types
    var name: String? = null
    println(name)

    var sport: String?
    sport = "Boxing"
    println(sport)
    sport = null

    // Null Checking
    var favNumber: Int? = 10

    // println(favNumber + 5) ERROR karena seperti menambahkan kotak kosong dengan angka 5
    println(favNumber!! + 5) // not null assertion operator (!!) mengeluarkan value dalam kotak secara paksa NOT SAFE!

    // Smart Cast
    if (favNumber != null){
        println(favNumber + 5)
    } else {
        println("Absence of value")
    }

    // Safe calls
    var myName: String? = "Mory"

    println(myName?.length) // Safe call operator (?.) akan mengecek apakah box myName memiliki value/null baru menjalankan perintah setelahnya
    println(myName?.length?.plus(8)) // Apabila terdapat proses setelah perintah contoh setelah length maka harus diberi safe call operator lainnya

    // The 'let' in Kotlin
    // body dari let hanya akan dijalankan ketika variable nullable ini memiliki value, jika null maka isi dari let tidak akan jalan
    myName?.let {
        println(myName.length)  // tidak perlu safe call operator lagi karena tidak berinteraksi dengan kotak, tapi langsung dengan value
        println(myName.length.plus(5))
        println("Tidak akan tercetak jika value myName? adalah null")
    }

    // Elvis Operator (?:)
    var myNumber: Int? = null
    var evenNumber = myNumber ?: 5 // elvis operator ?: akan dapat memberikan kesempatan bagi kita untuk memberikan nilai default ketika variabel null
    println(evenNumber)
}