package section14.objects

object E4FruitBook {

    val fruitList = mutableListOf<E4Fruit>()

    fun addFruit(fruit: E4Fruit){
        fruitList.add(fruit)
    }

    fun removeFruit(fruit: E4Fruit){
        fruitList.remove(fruit)
    }

    fun printFruitList(){
        fruitList.forEach {
            it.fruitColor
        }
    }
}