package section14.objects

// Creating Companion Object
object ComputerBook {

    var allComputers: MutableList<Computer> = mutableListOf()

    fun addComputer(computer: Computer) {
        allComputers.add(computer)
    }

    fun removeComputer(computer: Computer) {
        allComputers.remove(computer)
    }

    fun printComputers() {
        allComputers.forEach {
            println("${it.cName} - ${it.cBrand}")
        }
    }
}