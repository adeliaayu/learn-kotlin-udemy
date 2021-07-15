package section14.objects

object E22Menu {

    val menuList = mutableListOf<E22Food>()

    fun addEntree(food: E22Food){
        menuList.add(food)
    }

    fun removeEntree(food: E22Food){
        menuList.remove(food)
    }

    fun printMenu(){
        E22Menu.menuList.forEach {
            println("${it.name} tiap porsinya seharga ${it.price}")
        }
    }
}