package section14.objects

class E25Vegetable private constructor(val name: String, val type: String, val origin: String) {

    companion object {
        fun addNewVegetable(name: String, type: String, origin: String) : E25Vegetable {
            return E25Vegetable(name, type, origin)
        }
    }
}