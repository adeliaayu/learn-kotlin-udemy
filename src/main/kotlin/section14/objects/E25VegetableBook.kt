package section14.objects

object E25VegetableBook {

    val veggieList = mutableListOf<E25Vegetable>()

    fun addVeggie(veggie: E25Vegetable){
        veggieList.add(veggie)
    }

    fun removeVeggie(veggie: E25Vegetable){
        veggieList.remove(veggie)
    }

    fun printVeggieList(){
        veggieList.forEach {
            println("${it.name} are ${it.type} originated from ${it.origin}")
        }
    }
}