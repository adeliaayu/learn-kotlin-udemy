package section14.objects

class E24Fish private constructor(val name: String, val color: String, val size: String) {

    companion object {
        fun discoverNewFish(name: String, color: String, size: String) : E24Fish {
            return E24Fish(name, color, size)
        }
    }
}