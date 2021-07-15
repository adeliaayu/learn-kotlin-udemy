package section14.objects

// Using Singleton
object AnimalBookPractice {

    const val LION_NAME = "Lion"

    var allAnimals = mutableListOf<AnimalPractice>()

    fun addAnimal(animal: AnimalPractice){
        allAnimals.add(animal)
    }

    fun removeAnimal(animal: AnimalPractice){
        allAnimals.remove(animal)
    }

    fun printAllAnimal() {
        allAnimals.forEach {
            println(it.definition)
        }
    }
}