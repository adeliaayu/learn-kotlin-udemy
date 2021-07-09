package section5.typesandoperationinkotlin

/*
    1. Type Inference - 10 Int Constants, Buat 10 Constant tanpa type dengan isian integer
    2. Convert to Double, Ubah constants sebelumnya menjadi Double
    3. 10 String Variables, Buat dari real-world Objects
    4. Concatenation 3 of them, Jadikan 1 variable 3 dari 10 String sebelumnya
    5. String templates, Buat string templates dengan menambahkan integer constant didalamnya
    6. Create 5 pairs
    7. Create 5 triples
 */
fun main() {
    //1
    val myAge = 25
    val myHeight = 160
    val myWeight = 55
    val myApples = 30
    val myCandy = 40
    val myOranges = 23
    val myPillows = 3
    val myBlanket = 1
    val myMarker = 4
    val myPen = 10
    //2
    println(myAge.toDouble())
    println(myHeight.toDouble())
    println(myWeight.toDouble())
    println(myApples.toDouble())
    println(myCandy.toDouble())
    println(myOranges.toDouble())
    println(myPillows.toDouble())
    println(myBlanket.toDouble())
    println(myMarker.toDouble())
    println(myPen.toDouble())
    //3
    val myName = "My name is Adelia"
    val myJob = "My job is a Programmer"
    val myPet = "My pet is a Cat"
    val myMotorcycle = "I have 1 motorcycle"
    val myHobby = "I love playing video games"
    val mySiblings = "I have 2 sister"
    val myParents = "I have a mother and a father"
    val myBooks = "I have a lot of books"
    val myCologne = "I used adidas cologne"
    val myShoes = "I have some couple of shoes"
    //4
    val myProfile = myName + " " + myJob + " " + myMotorcycle
    println(myProfile)
    //5
    val myStringTemplates = "Saya berumur $myAge tahun"
    //6
    val pairSatu = Pair(23, 44)
    val pairDua = 5.6 to 33
    val pairTiga: Pair<Int, String> = Pair(23, "Apple")
    //7
    val tripleSatu = Triple(54, 234, 78.5F)
    val tripleDua = Triple("Sekolah", 55.34, 'b')
    val tripleTiga: Triple<Int, Float, Char> = Triple(64, 9.4F, 'p')
}