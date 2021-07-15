package section14.objects

object E24Sea {

    val fishInformation = mutableListOf<E24Fish>()

    fun registerFish(fish: E24Fish){
        fishInformation.add(fish)
    }

    fun removeFish(fish: E24Fish){
        fishInformation.remove(fish)
    }

    fun printFishList(){
        fishInformation.forEach {
            println("New fish has been found; Name:${it.name}, Color:${it.color}, Size:${it.size}")
        }
    }
}