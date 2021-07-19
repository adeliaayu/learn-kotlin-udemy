package section18.enumclasses

/*
    1. Create 5 Enum Classes
    2. Update order of enum
    3. Use properties and functions
    4. Use when with enum
    5. Create a sealed class with 5 sub-types
    6. Use enum to handle states
    7. Integrate nullability to your enums
 */

fun main(){

    // 2
    for (games in Games.values()){
        println("Games #${games.ordinal} adalah ${games.name}")
    }

    // 3
    val favGames = Games.FPS
    favGames.favoriteGame()

    val whatToWatch = Movies.genreMovieToWatch()
    println("Sekarang saatnya nonton film $whatToWatch")

    val myPet = Pet.Cat
    myPet.eat()

    val headsetImpian = HeadsetBrand.Sony
    headsetImpian.quality()

    CarBrand.printAll()

    // 4
    val myGames = Games.Adventure
    when (myGames){
        Games.Adventure -> println("Minecraft, Zelda")
        Games.FPS -> println("Fortnite, Paladins")
        Games.Simulation -> println("The Sims")
        else -> println("And much more others")
    }

    val movieList = Movies.Comedy
    when (movieList){
        Movies.Comedy -> println("Mr.Beans")
        Movies.Drama -> println("Twilight")
        Movies.Horror -> println("Annabelle")
        else -> println("Just pick one available")
    }

    val giftedPets = Pet.Cat
    when (giftedPets){
        Pet.Cat, Pet.Dog -> println("We can not kept them as our pet")
        Pet.Fish, Pet.Turtle -> println("Thank you for the gift")
    }

    val usedHeadset = HeadsetBrand.Samsung
    when (usedHeadset){
        HeadsetBrand.Samsung, HeadsetBrand.Sony -> println("Yeah, I've used that")
        HeadsetBrand.Beats, HeadsetBrand.Bose -> println("I have never used that before")
        else -> println("Maybe I've used once? I dont remember")
    }

    val dreamCar = CarBrand.Ferrari
    when (dreamCar){
        CarBrand.Ferrari, CarBrand.Jeep, CarBrand.Mini -> println("That's my dream car")
        CarBrand.Suzuki, CarBrand.Toyota -> println("That is mainstream car brand in Indonesia")
    }

    // 5
    val favVeggie = Vegetable.Garlic()
    println("Sayur favoritku berwarna ${favVeggie.color}")

    // 6
    val student1 = Student("Jimmy")
    student1.academicStatus(Status.Active)

    // 7
    val student2 = Student("Budi")
    student2.academicStatus(null)

}

// 1
enum class Games{
    /*
        Old order:
        FPS,
        Simulation,
        Adventure,
        Racing,
        RPG
     */
    // 2
    Adventure,
    FPS,
    Simulation,
    Racing,
    RPG;

    // 3
    fun favoriteGame(){
        println("Game favorite saya adalah ${this.name}")
    }
}

enum class Movies{
    Comedy,
    Drama,
    Horror,
    Scifi;

    // 3
    companion object {
        fun genreMovieToWatch(): Movies{
            return Movies.values()[(0..Movies.values().size).random()]
        }
    }
}

enum class Pet{
    Dog,
    Cat,
    Turtle,
    Fish;

    // 3
    fun eat(){
        println("$this lagi makan")
    }
}

enum class HeadsetBrand{
    Sony,
    Sennheiser,
    Beats,
    Bose,
    Samsung;

    // 3
    fun quality(){
        println("$this sounds good to me")
    }
}

enum class CarBrand{
    Toyota,
    Ferrari,
    Suzuki,
    Jeep,
    Mini;

    // 3
    companion object{
        fun printAll(){
            for (car in CarBrand.values()){
                println("This is a ${car.name}")
            }
        }
    }
}

// 5
sealed class Vegetable{
    abstract val color: String
    abstract val type: String

    class Cabbage : Vegetable() {
        override val color: String
            get() = "Green, Red or White"
        override val type: String
            get() = "Leafy"
    }

    class Ginger : Vegetable() {
        override val color: String
            get() = "Brown"
        override val type: String
            get() = "Roots"
    }

    class Spinach : Vegetable() {
        override val color: String
            get() = "Green"
        override val type: String
            get() = "Leafy"
    }

    class Potato : Vegetable() {
        override val color: String
            get() = "Brown, Red, Purple"
        override val type: String
            get() = "Root"
    }
    class Garlic : Vegetable() {
        override val color: String
            get() = "White"
        override val type: String
            get() = "Herbs"
    }
}

// 6
enum class Status{
    Active,
    Inactive,
    Finished
}

// 7
class Student(val name: String){
    fun academicStatus(status: Status?){
        when (status){
            Status.Active -> println("Status akademik $name - Aktif")
            Status.Inactive -> println("Status akademik $name - Tidak Aktif")
            Status.Finished -> println("Status akademik $name - Lulus")
            null -> println("Status akademik $name - Error")
        }
    }
}
