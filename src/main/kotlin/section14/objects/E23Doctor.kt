package section14.objects

class E23Doctor private constructor(val name: String, val specialize: String) {

    companion object {
        fun newDoctor(name: String, specialize: String) : E23Doctor {
            return E23Doctor(name, specialize)
        }
    }
}