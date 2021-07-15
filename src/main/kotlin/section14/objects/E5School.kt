package section14.objects

object E5School {

    var studentList = mutableListOf<E5Student>()

    fun addStudent(student: E5Student){
        studentList.add(student)
    }

    fun removeStudent(student: E5Student){
        studentList.remove(student)
    }

    fun printGoodStudents() {
        val goodStuds = studentList.filter { it.score > 90 }

        goodStuds.forEach {
            println("${it.name} adalah murid pintar")
        }
    }

}