package section14.objects

object E2Company {

    val employeeList = mutableListOf<E2Employee>()

    fun addEmployee(emp: E2Employee){
        employeeList.add(emp)
    }

    fun removeEmployee(emp: E2Employee){
       employeeList.remove(emp)
    }

    fun printAllEmployee(){
        employeeList.forEach {
            println("Bapak/Ibu ${it.name} adalah seorang ${it.job}")
        }
    }
}