package section6.basiccontrolflow

/*
    1. Create 10 Boolean Comparisons
    2. Create 10 Boolean Logic Example
    3. Create 5 String Equality Examples
    4. Create 5 If Else Expressions
    5. Create 5 If and Else If Expressions
    6. Write down the meaning of short circuiting
    7. Write down the meaning of scope
    8. Create 5 While Loops
    9. Create 5 DO-While Loops
    10. Break out while loops
 */

fun main(){
    // 1
    var boolean1 = (23 > 45)
    var boolean2 = (43 < 76)
    var boolean3 = (423 >= 545)
    var boolean4 = (57 >= 68)
    var boolean5 = (657 == 456)
    var boolean6 = (745 != 6785)
    var boolean7 = (7455 > 9856)
    var boolean8 = (25454 < 5657)
    var boolean9 = (100 >= 45)
    var boolean10 = (34 <= 65)

    //2
    var logic1 = (10 < 11 && 11 != 12)
    var logic2 = (10 > 11 && 11 != 12)
    var logic3 = (10 >= 11 && 11 == 12)
    var logic4 = (100 >= 500 || 50 != 60)
    var logic5 = (100 >= 500 || 50 <= 60) && 3 <= 65
    var logic6 = (100 >= 500 && 50 != 60) || 3 >= 65
    var logic7 = (100 >= 500 || 50 != 60) || ( 3 > 65 && 54 < 190 )
    var logic8 = (100 >= 500 || 50 != 60) && ( 3 >= 65 || 50 < 400 )
    var logic9 = (100 >= 500 && 50 != 60) && 3 > 65
    var logic10 = (100 >= 500 && 50 != 60) && ( 3 > 65 || 400 > 40 )

    //3
    var string1 = ("Apple" == "Apple")
    var string2 = ("Iphone" > "Samsung")
    var string3 = ("Apple" != "Pinapple")
    var string4 = ("Orange" < "Melons")
    var string5 = ("Watermelon" >= "Apple")

    //4
    if (10 > 5) {
        println("This is commonsense")
    } else {
        println("Maybe this could happen")
    }

    var age = 10
    if (age >= 17) {
        println("Sudah punya KTP")
    } else {
        println("Belum punya KTP")
    }

    var semangkaSegar = true
    if (semangkaSegar) println("Tentu saja")

    age = 20
    if (age < 17) {
        println("Belum boleh punya SIM")
    } else {
        println("Sudah boleh punya SIM")
    }

    var ipk = 3.6
    if (ipk > 3.5){
        println("Bagus dan pertahankan")
    } else {
        println("Tingkatkan belajarnya")
    }

    //5
    var scoreShooter = 5
    if (scoreShooter > 1 && scoreShooter <=3){
        println("Anda mendapatkan boneka kecil")
    } else if (scoreShooter > 3 && scoreShooter <= 6){
        println("Anda mendapatkan boneka besar")
    } else {
        println("Score anda tidak valid")
    }

    var myCarrot = 3
    if (myCarrot < 0 ){
        println("Tambahkan wortel")
    } else if (myCarrot >= 1 && myCarrot <=3){
        println("Wortel sudah pas")
    } else if (myCarrot > 3){
        println("Terlalu banyak wortel")
    }

    var wheels = 4
    if (wheels == 2){
        println("Sepeda motor")
    } else if (wheels == 4){
        println("Mobil")
    } else if (wheels > 4){
        println("Kendaraan besar")
    } else {
        println("UFO")
    }

    var monitor = 2
    if (monitor < 1) {
        println("Orang jaman dulu")
    } else if (monitor >= 1) {
        println("Orang masa kini")
    } else {
        println("Orang diantara masa")
    }

    var apples = 5
    if (apples >=0 && apples <= 10){
        println("Orang biasa")
    } else if (apples > 10){
        println("Tengkulak apel")
    }

    //6
    /*
    Kondisi dimana apabila dalam kondisi if expression menggunakan boolean logic AND atau OR,
    Apabila AND dan statement pertama (sebelah kiri AND) False maka seluruh kondisi IF menjadi False tanpa mengecek statement kedua,
    Apabila OR dan statement pertama (sebelah kiri OR) True maka seleruh kondisi IF menjadi True tanpa mengecek statement kedua
     */

    //7
    /*
    Scope adalah area dimana dimulai dari buka kurung kurawal ({) dan diakhiri dengan tutup kurung kurawal (})
    Variable dalam parent scope dapat diakses oleh child scope, tetapi tidak sebaliknya
     */

    //8
    var counter = 0
    while (counter < 5){
        println("Eat a cookie")
        counter++
    }

    counter = 0
    while (counter < 3){
        println("Put in more carrots")
        counter++
    }

    counter = 0
    while (counter < 10){
        println("Buy more apples")
        counter++
    }

    counter = 0
    while (counter < 10){
        println("Hello world")
        counter++
    }

    counter = 0
    while (counter > 2){
        println("Tidak akan tercetak")
    }

    //9
    counter = 0
    do {
        println("Pasti tercetak")
        counter++
    } while (counter > 13)

    counter = 0
    do {
        println("Lap sepatu dengan kain")
        counter++
    } while (counter < 5)

    counter = 0
    do {
        println("Lari 1 putaran lagi")
        counter++
    } while (counter < 12)

    counter = 0
    do {
        println("1 kesempatan lagi untuk melempar bola")
        counter++
    } while (counter < 3)

    counter = 0
    do {
        println("Petik bunga lainnya")
        counter++
    } while (counter < 15)

    //10
    while (true){
        println("Selamanya akan tercetak terus")
        break
    }
}