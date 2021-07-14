package section11.mapsandsets

/*
    1. Create 10 Maps
    2. Indexing
    3. Properties & Functions
    4. Create 5 mutable maps
    5. Add pairs
    6. Update pairs
    7. Remove pairs
    8. Iterate through maps
    9. Create 5 sets
    10. Create 2 arrays and convert them to sets
    11. Get set elements
    12. Add and Remove set element
 */

fun main(){
    //1
    var carMaps = mapOf(1 to "Toyota", 2 to "Innova", 3 to "Ignis")
    var fruitShopMaps = mapOf("Apple" to 5, "Orange" to 10, "Durian" to 2)
    var gradeMaps = mapOf("Andy" to 35, "Tony" to 90, "Lala" to 50)
    var numberMaps = mapOf(1 to 44, 2 to 67, 3 to 900)
    var vegetableMaps = mapOf(1 to "Cucumber", 2 to "Spinach", 3 to "Beans")
    var emptyMaps: HashMap<Int, Double> = hashMapOf()
    var clothesMaps: Map<String, String> = mapOf("Andy" to "Shirt", "John" to "Jumper")
    var clothesSizeMaps = mapOf("Tony" to 'M', "Tania" to 'S', "Valcon" to 'L')
    var ageMap = mapOf("Tony" to 16, "Tania" to 36, "Valcon" to 33)
    var ipkMap = mapOf("Andy" to 3.5, "Tony" to 2.4, "Lala" to 4.0)

    val numberGrade = mutableMapOf(1 to 23, 2 to 45, 3 to 44)
    numberGrade.put(4, 55)
    numberGrade.put(3, 67)
    println(numberGrade)

    if (fruitShopMaps.containsKey("Apple")){
        println("Benar")
    } else {
        println("Salah")
    }

    if (fruitShopMaps.containsValue(5)){
        println("Benar")
    } else {
        println("Salah")
    }

    //2
    println(carMaps[2])
    println(fruitShopMaps["Durian"])
    println(gradeMaps["Aram"])

    //3
    println(numberMaps.size)
    println(vegetableMaps.get(2))
    println(clothesMaps.isEmpty())

    //4
    var mutableCarMaps = mutableMapOf(1 to "Toyota", 2 to "Innova", 3 to "Ignis")
    var mutableAgeMaps: MutableMap<String, Int> = mutableMapOf("Tony" to 16, "Tania" to 36, "Valcon" to 33)
    var mutableIPKMaps = mutableMapOf("Andy" to 3.5, "Tony" to 2.4, "Lala" to 4.0)
    var mutableClothesSizeMaps: MutableMap<String, Char> = mutableMapOf("Tony" to 'M', "Tania" to 'S', "Valcon" to 'L')
    var mutableGradeMaps = mutableMapOf("Andy" to 35, "Tony" to 90, "Lala" to 50)

    //5
    mutableCarMaps.put(4, "Kijang")
    mutableAgeMaps["Sayi"] = 15

    //6
    mutableIPKMaps["Andy"] = 3.7
    mutableGradeMaps.put("Andy", 36)

    //7
    mutableClothesSizeMaps.remove("Tony")
    println(mutableClothesSizeMaps)
    for ((name, size) in mutableClothesSizeMaps){
        println("$name - $size")
    }
    mutableAgeMaps.remove("Tony", 16)

    //8
    for ((name, ipk) in mutableIPKMaps){
        println("$name memiliki IPK $ipk")
    }
    for (name in mutableIPKMaps.keys){
        println(name)
    }
    for (ipk in mutableIPKMaps.values){
        println(ipk)
    }

    //9
    var numberSets = setOf(4, 6, 3, 7, 4, 3)
    var alphabetSets = setOf('D', 'R', 'T', 'E', 'T')
    var veggieSets = setOf("Kol", "Bawang", "Bayam", "Bombai")
    var fruitSets = setOf("Apple", "Orange", "Durian", "Durian")
    var ipkSet = setOf(2.3, 4.0, 3.2, 3.3)

    //10
    var numberArray = arrayOf(5, 3, 6, 7, 4)
    var changeNumberSet = setOf(*numberArray)
    var randomAlphabetArray = arrayOf('R', 'S', 'F', 'T', 'H')
    var changeAplhaSet = setOf(*randomAlphabetArray)

    //11
    changeNumberSet.elementAt(2)
    changeAplhaSet.elementAt(0)

    //12
    val nameSets = mutableSetOf("Andy", "Duit", "Iman", "Loli")
    nameSets.add("Jono")
    println(nameSets)
    nameSets.remove("Duit")
    println(nameSets)

}