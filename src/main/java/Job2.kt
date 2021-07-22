class Job2 @JvmOverloads constructor(var name: String, var salary: Int, var jobType: JobType) {
    override fun toString(): String {
        return "$name - $salary - $jobType"
    }

    object JobNames {

        val job1 = "Android Development"
        val job2 = "iOS Development"
        val job3 = "Actor"
        val job4 = "DJ"
        val job5 = "Stand Up Comedy"
        val job6 = "Web Development"
    }

    // Static Values and functions vs Kotlin
    companion object {
        const val numberOfJobs = 6

        @JvmStatic
        fun maxSalary() : Int {
            return 5000
        }
    }
}

enum class JobType {

    NineToFive,
    Freelance


}