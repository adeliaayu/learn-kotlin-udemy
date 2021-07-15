package section14.objects

// Creating Companion Object
class Computer private constructor(val cID: Int, val cName: String, val cBrand: String) {

    companion object {
        var currentComputerID = 0

        fun createNewComputer(cName: String, cBrand: String) : Computer {
            currentComputerID += 1

            return Computer(currentComputerID, cName, cBrand)
        }
    }
}