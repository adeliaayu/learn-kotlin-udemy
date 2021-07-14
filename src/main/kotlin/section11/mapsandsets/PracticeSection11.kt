package section11.mapsandsets

fun main() {
    
    // Maps
    /*
        1. Unordered
        2. Key - Value
        3. Indexing
        4. Kalo ga ada di map akan return value null
     */

    var names : Map<Char, String> = mapOf('A' to "Mory", 'C' to "Jack", 'R' to "John")
    println(names)

    var mutableNames = mutableMapOf('A' to "Gary")
    println(mutableNames)

    var emptyNames: Map<Int, String> = mutableMapOf()       // Empty Map
    var computer: HashMap<Int, Double> = HashMap(30)    // Hashmap

    // Indexing in Pairs
    println(names['A'])     // Akses menggunakan key
    println(names['B'])     // Apabila tidak ada key tersebut maka akan kembalikan null

    // Using properties and functions in Maps
    println(names.get('R'))     // menggunakan functions get
    println(names.get('L'))     // apabila tidak ada maka kembalian null

    if (names.isEmpty()){       // menggunakan function isEmpty
        println("The map is empty")
    } else {
        println("The map is not empty")
    }

    println(names.size)     // menggunakan properties size

    // Adding elements
    var moryBoxer = mutableMapOf("punchPower" to 100)

    moryBoxer.put("punchSpeed", 70)         // ADD menggunakan function PUT( key, value )
    println(moryBoxer["punchPower"])

    moryBoxer["stamina"] = 90           // ADD menggunakan indexing
    println(moryBoxer.get("stamina"))

    // Updating elements
    moryBoxer.put("punchPower", 200)        // Update menggunakan function PUT( key, value )
    println(moryBoxer["punchPower"])

    var oldPunchSpeed = moryBoxer.put("punchSpeed", 150)        // function PUT akan return value yang lama ketika update value
    println(oldPunchSpeed)
    println(moryBoxer)

    moryBoxer["stamina"] = 170      // Update menggunakan indexing
    println(moryBoxer)

    // Removing elements
    moryBoxer.remove("stamina")     // Menghapus menggunakan function REMOVE( key )
    println(moryBoxer)

    moryBoxer.remove("punchSpeed", 300)     // menggunakan function REMOVE( key, value ) dan hanya akan terhapus jika key dan value sesuai
    println(moryBoxer)

    moryBoxer.remove("punchSpeed", 150)
    println(moryBoxer)

    // Iterating through map
    var personsAndJobs = mapOf("Person A" to "Boxer", "Person B" to "Pianist", "Person C" to "Gardener")
    println(personsAndJobs)

    for ((person, jobs) in personsAndJobs){         // menggunakan for
        println("Pekerjaan $person adalah $jobs")
    }

    for (person in personsAndJobs.keys){         // menggunakan for untuk keys
        println(person)
    }

    for (job in personsAndJobs.values){         // menggunakan for untuk value
        println(job)
    }


    // Sets
    /*
        1. Unique value, tidak mungkin ada value yang bernilai sama
        2. Inclusion
     */

    var alphabetSet: Set<Char> = setOf('B', 'G', 'A', 'C', 'C')        // C hanya disimpan 1 kali
    println(alphabetSet)                                               // ex: [B,G,A,C]

    var emptySet = HashSet<Int>()       // empty set

    // Converting Array to Set
    // * Spread operator

    var alphabetArray = arrayOf('A', 'B', 'C', 'A', 'A', 'D', 'A')
    println(alphabetArray.joinToString())

    var alphabetSet1 = setOf(*alphabetArray)    // menggunakan spread operator (*) untuk memasukkan array kedalam function setOf
    println(alphabetSet1)

    var mutableNumberSet = mutableSetOf(4, 2, 6, 3)       // mutable set
    println(mutableNumberSet)

    // Getting element from Sets
    var alphabetSet2: Set<Char> = setOf('B', 'G', 'A', 'C', 'C')

    if (alphabetSet2.contains('G')){            // menggunakan function contains
        println("G does exist")
    } else {
        println("G does not exist")
    }

    if ('H' in alphabetSet2) {          // menggunakan in
        println("H does exist")
    } else {
        println("H does not exist")
    }

    println(alphabetSet2.first())
    println(alphabetSet2.last())
    println(alphabetSet2.elementAt(0))      // menggunakan index dengan function elementAt(idx)

    // Adding and removing element
    var mutableAlphabetSet: MutableSet<Char> = mutableSetOf('B', 'G', 'A', 'C', 'C')

    mutableAlphabetSet.add('T')         // menambahkan di akhir set menggunakan ADD
    println(mutableAlphabetSet)

    mutableAlphabetSet.add('C')         // apabila sudah ada dalam set maka tidak akan muncul menggunakan ADD
    println(mutableAlphabetSet)

    mutableAlphabetSet.remove('C')      // menghapus menggunakan function remove
    println(mutableAlphabetSet)

}