package section7.advancedcontrolflow

/*
    1. Create 5 closed ranges
    2. Create 5 half-open ranges
    3. Create 10 for loops
    4. Create 5 repeat for loops
    5. Use Labeled Statements
    6. Create 10 when expressions
    7. Return Value from 5 when expressions
    8. Create 10 advanced when expressions using ranges and matching a branch to a condition
 */

fun main() {

    //1
    val countApples: IntRange = 1..10
    val countOranges: IntRange = 10..20
    val countWheels: IntRange = 2..4
    val countStairs: IntRange = 1..40
    val countLamps: IntRange = 1..5

    //2
    val countStars: IntRange = 0 until 100000 // 0..99999
    val countSheeps: IntRange = 0 until 2000 // 0..1999
    val countSpoons: IntRange = 0 until 5 // 0..5
    val countForks: IntRange = 0 until 10 // 0..9
    val countCalories: IntRange = 0 until 5000 // 0..4999

    //3
    for (i in 1..5){
        println("For ini menggunakan closed range dengan constant=$i")
    }
    for (i in 1 until 5){
        println("For ini menggunakan half open range dengan constant=$i")
    }
    for (i in 1 until 10 step 2){
        println("For ini menggunakan half open range dengan jarak 2 constant=$i")
    }
    for (i in 10 downTo 0 step 3) {
        println("For ini menggunakan decreasing range dengan jarak 3 constant=$i")
    }
    var hasilPenjumlahan = 0
    for (i in 1..10){
        hasilPenjumlahan += 4
    }
    var hasilPerkalian = 1
    for (i in 1 until 10){
        hasilPerkalian *= 4
    }
    var hasilPengurangan = 100
    for (i in 1..15){
        hasilPengurangan -= i
    }
    var hasilPembagian = 200
    for (i in 5 downTo 0 step 2){
        hasilPembagian /= i
    }
    for (i in 20 downTo 10){
        println("Hasil ini berakhir di constant i=$i")
    }
    for (i in 0..0){
        println("Ini hanya tercetak 1 kali")
    }


    //4
    repeat(5){
        println("Teks ini menggunakan repeat")
    }
    repeat(3){
        println("Teks ini akan tercetak sebanyak 3 kali, posisi di $it kali")
    }
    var multiple = 1
    repeat(5){
        multiple *= 2 + 1
    }
    repeat(2){
        multiple /= 2
    }
    repeat(5){
        multiple++
    }

    //5
    loopForCount@for (i in 1..20){
        if (i % 2 == 0){
            continue
        } else if (i > 15){
            break@loopForCount
        }
        println(i)
    }

    //6
    var myPhone = "Samsung"
    when (myPhone) {
        "Samsung" -> println("My phone is Samsung")
        "Apple" -> println("My phone is iPhone")
    }

    var myCanNumber = 123
    when (myCanNumber) {
        1 -> println("My can number is 1")
        12 -> println("My can number is 12")
        123 -> println("My can number is 123")
    }

    var myFavoriteNumber = 3
    when (myFavoriteNumber){
        1,2,3,4,5 -> println("My favorite number in a 1 to 5 range")
        6,7,8,9,10 -> println("My favorite number in 6 to 10 range")
        else -> println("My favorite number is something else")
    }

    var myFavSoda = "Root Beer"
    when (myFavSoda) {
        "Cola", "Sprite, Fanta" -> println("My favorite soda is from coca-cola")
        "Pepsi Blue", "Pepsi" -> println("My favorite soda is from pepsi")
        "Root beer", "Sarsaparila" -> println("My favorite soda is from AW")
        else -> println("My favorite soda is something else")
    }

    var wheels = 4
    when (wheels){
        2 -> println("Sepeda motor")
        3 -> println("Becak")
        4 -> println("Mobil")
        else -> println("Lainnya")
    }

    var myLaptop = "ACER"
    when (myLaptop){
        "ACER" -> println("My laptop is ACER")
        "ASUS" -> println("My laptop is ASUS")
    }

    var flower = "Tulip"
    when (flower) {
        "Tulip", "Mawar", "Melati" -> println("Dia suka bunga ini")
        "Kenanga", "Terompet" -> println("Dia tidak suka bunga ini")
        else -> println("Dia suka bunga")
    }

    var bed = "Pillows"
    when (bed){
        "Pillows", "Bolster" -> println("Adalah kombinasi tepat")
        "Shoes", "Socks" -> println("Adalah kombinasi yang salah")
    }

    var shoes = "Adidas"
    when (shoes){
        "Adidas", "Nike" -> println("Ini adalah merk sepatu favoritnya")
        "New Balance", "Sketchers" -> println("Dia tidak terlalu suka sepatu ini")
        else -> println("Dia biasa saja dengan sepatu lain")
    }

    var headset = "Sony"
    when (headset){
        "Sony", "Seinheisser" -> println("Dia suka headset merk ini")
        "Beats", "Xiaomi" -> println("Dia benci headset dengan merk ini")
    }

    var IPK = 4
    when (IPK) {
        4 -> println("Cum Laude")
        1,2,3 -> println("Tidak cum laude")
        else -> println("Data yang dimasukkan salah")
    }

    //7
    var strip = 2
    var testResult = when(strip) {
        1 -> "Negatif Covid"
        2 -> "Positif Covid"
        else -> "Tes gagal"
    }

    wheels = 4
    var kendaraan = when(wheels) {
        2 -> "Motor"
        4 -> "Mobil"
        else -> "Lainnya"
    }

    var readBooks = 10
    var kutuBuku = when(readBooks){
        1,2,3,4,5 -> "Bukan kutu buku"
        6,7,8,9,10 -> "Kutu buku"
        else -> "Bisa jadi bukan kutu buku"
    }

    var monitor = "LG"
    var pabrikAsal = when(monitor){
        "LG", "Samsung" -> "Korea Selatan"
        "Xiaomi", "Mi" -> "Cina"
        else -> "Negara lainnya"
    }

    var bolpen = "Pilot"
    var ketahanan = when(bolpen){
        "Pilot", "Standart" -> "Bolpen awet dan bagus"
        "Queens", "Koolins" -> "Bolpen murah dan mudah rusak"
        else -> "Selalu beli bolpen yang bagus"
    }

    //8
    var nilai = 100
    when (nilai) {
        in 1..75 -> println("Nilai dibawah KKM")
        in 76..100 -> println("Nilai diatas KKM")
        else -> println("Nilai yang dimasukkan salah")
    }

    var IP = 3.6
    when (IP) {
        in 1.0..3.5 -> println("Tingkatkan lagi nilai anda")
        in 3.5..4.0 -> println("Nilai anda sudah baik, pertahankan terus")
        else -> println("Input invalid")
    }

    var jumlahUang = 2000
    when {
        jumlahUang < 5000 -> println("Uang yang dibawa kurang dari yang harus dibayar")
        jumlahUang == 5000 -> println("Jumlah uang pas tanpa kembalian")
        jumlahUang > 5000 -> println("Jumlah uang cukup dengan kembalian")
    }

    var usia = 12
    when (usia) {
        in 6..12 -> println("Pendidikan SD")
        in 13..15 -> println("Pendidikan SMP")
        in 16..18 -> println("Pendidikan SMA")
    }

    var gaji = 5000000
    when (gaji) {
        in 1000000..3000000 -> println("Gaji dibawah UMK")
        in 3000001..6000000 -> println("Gaji diatas UMK dan sedang")
        in 6000001..10000000 -> println("Gaji diatas UMK dan tinggi")
        else -> println("Masukkan gaji yang valid")
    }

    usia = 45
    when {
        usia >= 21 && usia < 54 -> println("Berhak mendapatkan kredit rumah")
        usia < 21 -> println("Terlalu muda untuk mendaftar kredit")
        usia > 54 -> println("Terlalu tua untuk mendapatkan kredit")
    }

    var mouse = 50000
    when (mouse) {
        in 0..150000 -> println("Mouse murah, hati-hati dalam membeli")
        in 150001..300000 -> println("Mouse gaming yang bagus")
        in 300001..4000000 -> println("Mouse gaming yang mahal dan biasanya tidak perlu semahal ini")
        else -> println("Inputan harga kurang valid")
    }

    var jumlahKaki = 4
    when (jumlahKaki){
        in 1..4 -> println("Hewan ini adalah hewan darat")
        0 -> println("Hewan ini adalah hewan laut atau melata")
        else -> println("Hewan apakah ini?")
    }

    var jumlahMuridOffline = 25
    when (jumlahMuridOffline) {
        in 1..20 -> println("Kelas sangat kondusif")
        in 21..30 -> println("Kelas cukup kondusif, meskipun terlalu ramai")
        in 31..60 -> println("Kelas terlalu ramai, kurangi jumlah murid")
        else -> println("Hindari kelas terlalu banyak")
    }

    var jagaJarak = 3
    when (jagaJarak){
        in 0..2 -> println("Terlalu dekat")
        in 2..5 -> println("Jarak aman")
        in 5..10 -> println("Jarak terlalu jauh")
    }

    var jumlahPesanan = 5
    when (jumlahPesanan){
        in 1..3 -> println("Sedikit")
        in 4..6 -> println("Cukup banyak")
        in 6..10 -> println("Terlalu banyak")
    }
 }