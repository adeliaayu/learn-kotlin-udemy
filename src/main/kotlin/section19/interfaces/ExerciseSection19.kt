package section19.interfaces

/*
    1. Create 5 Interfaces
    2. Create 5 Methods
    3. Create 5 Properties
    4. Create 5 Classes
    5. Default implementation
    6. Inherit from another interface
    7. Conform to multiple interfaces
    8. Use Iterator Interface
    9. Use Comparable Interface
 */

fun main(){

    // 8
    val myPets = listOf("Dog", "Bird", "Fish", "Cat")
    val myCars = mapOf(1 to "Tesla Model X", 2 to "Suzuki Ignis", 3 to "Jeep Wrangler Rubicon")

    for (pet in myPets) {
        println(pet)
    }

    for (car in myCars.values) {
        println(car)
    }

    // 9
    val job1 = Job(3_500_00.00)
    val job2 = Job(6_000_00.00)

    println(job1.compareTo(job2))
}

// 1
interface Animal{
    // 3
    var name: String
    var age: Int
    var species: String
    var color: String
    var food: String

    //2 & 5
    fun eat(){
        println("Hewan apapun harus makan")
    }
    fun sleep()
    fun play()
    fun move()
    fun talk()
}

// 4
class Cat(override var name: String,
          override var age: Int,
          override var species: String,
          override var color: String,
          override var food: String,
          override var race: String,
          override var country: String,
          override var language: String
) : Animal, People {
    override fun eat() {
        println("$name makan ikan")
    }

    override fun sleep() {
        println("$name butuh tidur")
    }

    override fun play() {
       println("$name suka bermain kejar-kejaran")
    }

    override fun origin() {
        TODO("Not yet implemented")
    }

    override fun move() {
        println("Kucing berjalan dengan 4 kakinya")
    }

    override fun talk() {
        println("Kucing mengeong")
    }

}

// 7
interface People{

    var name: String
    var age: Int
    var race: String
    var country: String
    var language: String

    fun eat()
    fun work() {
        println("Manusia memiliki beragam jenis pekerjaan")
    }
    fun sleep()
    fun play()
    fun origin()

}

interface Profession{

    var jobTitle: String
    var salary: String
    var duration: Int

    fun workingHours()
}

class Doctor (
    override var name: String,
    override var age: Int,
    override var race: String,
    override var country: String,
    override var language: String,
    override var jobTitle: String,
    override var salary: String,
    override var duration: Int
) : People, Profession {
    override fun eat() {
        println("$name suka makan sushi")
    }

    override fun work() {
        println("$name bekerja di $country")
    }

    override fun sleep() {
        println("$name tidur kurang dari 6 jam")
    }

    override fun play() {
        println("$name hobi traveling")
    }

    override fun origin() {
        println("$name adalah keturunan $race yang bertempat tinggal di $country")
    }

    override fun workingHours() {
        println("$jobTitle biasa bekerja selama $duration")
    }

}

// 6
interface Machine{
    var material: String

    fun automize()
}

interface Vehicle: Machine{

    var brand: String
    var type: String
    var capacity: Int
    var color: String
    var fuel: String

    fun move()
    fun turn() {
        println("Pada umumnya kendaraan membelokan arah roda depannya untuk berbelok")
    }
    fun launch()
    fun refuel()
    fun service()
}

// 6
class Car(
    override var material: String,
    override var brand: String,
    override var type: String,
    override var capacity: Int,
    override var color: String,
    override var fuel: String
) : Vehicle{
    override fun automize() {
        println("Fungsi dari mesin adalah otomatisasi")
    }

    override fun move() {
        println("Mobil $brand $type ini cocok untuk medan apapun")
    }

    override fun turn() {
        println("Mobil menggunakan setir berbentuk roda")
    }

    override fun launch() {
        println("Mobil $brand memiliki fitur launch")
    }

    override fun refuel() {
        println("Mobil $brand menggunakan $fuel sebagai bahan bakarnya")
    }

    override fun service() {
        println("Mobil membutuhkan perawatan setiap bulannya")
    }

}

interface Computer{

    var brand: String
    var color: String
    var size: Int
    var ram: Int
    var storage: Int

    fun takePhotos()
    fun createDocument() {
        println("Komputer digunakan untuk membuat dokumen")
    }
    fun typing()
    fun playMovies()
    fun playGames()
}

class Smartphone(
    override var brand: String,
    override var color: String,
    override var size: Int,
    override var ram: Int,
    override var storage: Int
) : Computer {
    override fun takePhotos() {
        println("HP $brand mengambil foto dengan kualitas bagus")
    }

    override fun createDocument() {
        println("HP ini juga dapat membuat dan menyimpan banyak dokumen dengan $storage GB penyimpanan")
    }

    override fun typing() {
        println("Mengetik di hp dilakukan pada layar")
    }

    override fun playMovies() {
        println("HP dapat digunakan untuk menonton film")
    }

    override fun playGames() {
        println("Banyak gim yang tersedia di store")
    }

}

interface Extraterrestrial{

    var planet: String
    var vehicle: String
    var age: Int
    var color: String
    var specialFeatures: String

    fun eat()
    fun flying() {
        println("Mahluk luar angkasa selalu terbang diangkasa")
    }
    fun kidnapping()
    fun sleep()
    fun research()
}

class Alien(
    override var planet: String,
    override var vehicle: String,
    override var age: Int,
    override var color: String,
    override var specialFeatures: String
) : Extraterrestrial{
    override fun eat() {
        println("Tidak ada yang tahu alien makan apa")
    }

    override fun flying() {
        println("Alien terbang dari planet $planet menggunakan $vehicle")
    }

    override fun kidnapping() {
        println("Alien dikatakan suka menculik untuk riset")
    }

    override fun sleep() {
        println("Alien tidur atau tidak juga tidak tahu")
    }

    override fun research() {
        println("Berdasarkan riset alien memiliki $specialFeatures dan berwarna $color")
    }
}

// 9
class Job(val salary: Double): Comparable<Job>{
    override fun compareTo(other: Job): Int {
        return when {
            salary > other.salary -> 1
            salary == other.salary -> 0
            else -> -1
        }
    }

}
