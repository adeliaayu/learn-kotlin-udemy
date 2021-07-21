package section20.generics

/*
    1. Create 5 Lists
    2. Access first value
    3. Create 5 Maps
    4. Same Keys and Different types of values
    5. Extension on types with generic constraints
    6. Manufacture your own generic constraints
    7. Use interfaces
    8. Create a Generic Interface
    9. Use star projection
    10. Use reified type parameters
    11. Use in and out variances in your generic constraints
 */

fun main() {

    // 1
    val randomList = listOf<Any>(4.3, 6, 'A', "random")
    val numberList = listOf(4, 5.3, 6, 88, 74)
    val nameList = listOf("Adel", "Ahmad", "Cola", "Gendis")
    val ageList = listOf(64, 43, 55, 23, 11)
    val veggieList = listOf("Mushroom", "Spinach", "Peas", "Beans")

    // 2
    println(randomList.first())
    println(numberList.first())
    println(nameList.first())
    println(ageList.first())
    println(veggieList.first())

    // 3
    val absenceMaps = mapOf(1 to "Tobi", 2 to "Gobi", 3 to "Bobi", 4 to "Robi")
    val groceryMaps = mapOf(3 to "Apple", 5 to "Orange", 5 to "Kelp")
    val cityMaps = mapOf("Jakarta Barat" to "DKI Jakarta", "Surabaya" to "Jawa Timur", "Denpasar" to "Bali")
    val menuMaps = mapOf(1 to "Nasi goreng", 2 to "Mi goreng", 3 to "Ayam goreng")
    val flowerMaps = mapOf(1 to "Tulip", 2 to "Rose", 3 to "Jasmine")

    // 4
    val randomMaps = mapOf(1 to 4.5, 2 to "Apple", 3 to 5.4, 4 to 'B')

    // 5
    println(randomList.printAllList())

    // 6
    val vegetable =
        listOf<Vegetable>(Vegetable("Spinach", true), Vegetable("Cabbage", false), Vegetable("Ginger", true))
    val veggieHarvested = Harvest(vegetable)
    veggieHarvested.deliveredHarvestedThingsToSortingSite()
    veggieHarvested.deliverHarvestedThingsToCustomer(VeggieCrate())
    veggieHarvested.finalize()
}

// 5
fun List<Any>.printAllList(): String {
    return this.map { "$it" }.joinToString("\n")
}

// 6
class Harvest<T : QualityCheck>(harvestedThings: List<T>) {

    private var harvestedThingsOnFarm = mutableListOf<T>()
    private var harvestedThingsOnSortingSite = mutableListOf<T>()
    private var harvestedThingsOnDelivery = mutableListOf<T>()
    private var defectHarvestedThings = mutableListOf<T>()

    init {
        harvestedThingsOnFarm.addAll(harvestedThings)
    }

    fun deliveredHarvestedThingsToSortingSite() {
        while (harvestedThingsOnFarm.count() > 0) {
            val harvested = harvestedThingsOnFarm.removeAt(0)

            if (harvested.checkedQuality()) {
                harvestedThingsOnSortingSite.add(harvested)
                println("Harvested $harvested delivered to sorting site")
            } else {
                defectHarvestedThings.add(harvested)
                println("$harvested did not passed quality check")
            }
        }
    }

    fun deliverHarvestedThingsToCustomer(crate: Crate<T>) {
        while (harvestedThingsOnSortingSite.count() > 0) {
            val sorted = harvestedThingsOnSortingSite.removeAt(0)

            harvestedThingsOnDelivery.add(sorted)
            println("Sorted $sorted being delivered to the customer")

        }
    }

    fun finalize() {
        println("The produce that has been delivered are $harvestedThingsOnDelivery")
        println("These produce did not pass quality check $defectHarvestedThings")
    }
}

class Vegetable(val name: String, val goodQuality: Boolean) : QualityCheck {
    override fun checkedQuality(): Boolean {
        return goodQuality
    }

    override fun toString(): String {
        return name
    }
}

// 7
interface QualityCheck {
    fun checkedQuality(): Boolean
}

// 8
interface Crate<T> {
    fun isCrateEmpty(): Boolean
    fun addProduceToCrate(produce: T)
    fun listOfProduce(): List<T>
}

class VeggieCrate : Crate<Vegetable> {

    private val allProduce = mutableListOf<Vegetable>()

    override fun isCrateEmpty(): Boolean {
        return allProduce.count() <= 0
    }

    override fun addProduceToCrate(produce: Vegetable) {
        allProduce.add(produce)
    }

    override fun listOfProduce(): List<Vegetable> {
        return allProduce.toList()
    }

}