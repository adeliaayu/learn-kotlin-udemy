package section14.objects

object E23Hospital {
    val doctorInformation = mutableListOf<E23Doctor>()

    fun addDoctor(doctor: E23Doctor){
        doctorInformation.add(doctor)
    }

    fun removeDoctor(doctor: E23Doctor){
        doctorInformation.remove(doctor)
    }

    fun printDoctorList(){
        doctorInformation.forEach {
            println("${it.name} adalah dokter spesialis ${it.specialize}")
        }
    }
}