package section14.objects

class E22Food private constructor(val name: String, val price: Int) {

    companion object {
        fun addNewFood(name: String, price: Int) : E22Food {
            return E22Food(name, price)
        }
    }
}