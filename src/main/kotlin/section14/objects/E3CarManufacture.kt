package section14.objects

object E3CarManufacture {

    val carDescription = mutableListOf<E3Car>()

    fun addCar(mobil: E3Car){
        carDescription.add(mobil)
    }

    fun removeCar(mobil: E3Car){
        carDescription.remove(mobil)
    }

    fun printCarList(){
        carDescription.forEach {
            it.carInfoStatus
        }
    }

    fun cariTipe(type: String){
         val mobilSUV = carDescription.filter {
            it.type.uppercase().contains(type)
        }

        mobilSUV.forEach {
            println("Mobil SUV yang kami miliki adalah ${it.name}")
        }
    }
}