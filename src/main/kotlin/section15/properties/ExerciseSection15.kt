package section15.properties

import kotlin.properties.Delegates

/*
    1. Create 5 classes
    2. 5 properties for each classes
    3. Use Custom accessors
    4. Companion Object for each class
    5. Observe one property for each class
    6. Limit one variable of each class
    7. Create one lazy property for each class
    8. Use lateinit to delay the initialization of one property in each class
    9. Create Extension Properties
 */

fun main() {

    val employee1 = Employee("Danda", "Manajer", 257000.00, 4)
    Employee.numberOfEmployees++
    println(employee1.skill)
    println(employee1.bonusTahunan)
    employee1.bonusTahunan = 146000
    println(employee1.bonusTahunan)
    val employee2 = Employee("Sumin", "HRD", 164000.00, 2)
    employee2.newEmployee = true
    val employee3 = Employee("Hanji", "Admin", 55000.00, 5)
    employee3.newEmployee = true
    val employee4 = Employee("Tobat", "Asisten", 70000.00, 6)
    employee4.newEmployee = true
    println(Employee.numberOfEmployees)
    employee1.bonusGiven = employee1.bonusTahunan
    println(employee1.bonusGiven)
    employee2.bonusGiven = employee2.bonusTahunan
    println(employee2.bonusGiven)
    println(employee1.processNewEmployee)
    employee1.company = "Bank Mandiri"
    println(employee1.company)
    println(employee3.processNewEmployee)


    val student1 = Student("Andi", 663434)
    Student.numberOfStudents++
    student1.ipk = 3.5
    student1.faculty = "Ilmu Komputer"
    student1.major = "Teknik Informatika"
    println(student1.condition)
    val student2 = Student("Syahada", 534533)
    student2.newStudentAdministered = true
    println(Student.numberOfStudents)
    student1.studentBodyGrade = student1.ipk
    println(student1.studentBodyGrade)
    println(student1.isThisStudentGood)
    student1.school = "Harvard University"
    if (student1.isSchoolInitialized()){
        println(student1.school)
    }
    println(student2.smartpants)


    val car1 = Car("Ignis", "Suzuki", "Biru")
    Car.numberOfCars++
    println(car1.pemesanan)
    car1.wheel = 2
    println(car1.extraWheel)
    val car2 = Car("Jimny", "Suzuki", "Hijau")
    car2.newCarIndent = true
    car1.orderedCar = "Black"
    println(car1.orderedCar)
    println(car2.notificationIndentCar)
    car1.stickerColor = "Green"
    println(car1.stickerColor)
    println(car2.indentCarColor)


    val phone1 = Smartphone("Galaxy S20", "Samsung", 64)
    Smartphone.numberOfSmartphones++
    println(phone1.phoneInfo)
    val phone2 = Smartphone("iPhone 8", "Apple", 128)
    phone2.newSmartphone = true
    println(Smartphone.numberOfSmartphones)
    phone1.orderedStorageAmount = phone1.storage
    println(phone1.orderedStorageAmount)
    phone2.orderedStorageAmount = phone2.storage
    println(phone2.orderedStorageAmount)
    println(phone1.deliverThePhone)
    phone2.case = "Red"
    println(phone2.case)
    println(phone1.withCasing)


    val doctor1 = Doctor("dr. Abidin", "Jantung")
    doctor1.newDoctorAdded = true
    println(doctor1.hospital)
    println(Doctor.numberOfDoctors)
    doctor1.hospital = "RS Melati Husada"
    doctor1.howManyHospitalChanged = true
    doctor1.hospital = "RS Kasih Ibu"
    doctor1.howManyHospitalChanged = true
    println(doctor1.hospital)
    println(Doctor.numberOfHospitalChanged)
    doctor1.doctorsAge = 76
    println(doctor1.doctorsAge)
    println(doctor1.callTheDoctor)
    doctor1.alumni = "Universitas Indonesia"
    println(doctor1.alumni)
    println(doctor1.credibility)
}

//1
class Employee(val name: String, val jobTitle: String, var salary: Double, var jobLength: Int) {
    val skill: String
        get() {
            return "Skill yang wajib dimiliki $jobTitle adalah berpikir kritis"
        }
    var bonusTahunan: Int
        get() {
            return salary.toInt() * jobLength
        }
        set(value) {
            salary = value.toDouble()
        }

    companion object {
        var numberOfEmployees = 0
        var maximumBonus = 5000000
    }

    var newEmployee: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfEmployees++
        }
    }

    var bonusGiven by Delegates.vetoable(0)
    { _, _, newValue ->
        if (newValue > maximumBonus) {
            println("You got maximum bonus this year $maximumBonus")
            false
        } else {
            println("Happy bonus")
            true
        }
    }

    val processNewEmployee: String by lazy {
        "Processing new employee"
    }

    lateinit var company:String
}

val Employee.grading: String
get() {
    return "$name memiliki kinerja baik"
}


class Student(val name: String, val studentID: Int) {
    var ipk: Double = 0.0
    var faculty: String = ""
    var major: String = ""

    val condition: String
        get() {
            return "$name - Fakultas $faculty Jurusan $major memiliki IPK sebesar $ipk"
        }

    companion object {
        var numberOfStudents = 0
        var minimumIPK = 2.5
    }

    var newStudentAdministered: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfStudents++
        }
    }

    var studentBodyGrade by Delegates.vetoable(0.0)
    { _, _, newValue ->
        if (newValue < minimumIPK) {
            println("You're not allowed to be a member in Student Body")
            false
        } else {
            println("You're good to go")
            true
        }
    }

    val isThisStudentGood: String by lazy {
        "$name memiliki nilai IPK $ipk"
    }

    lateinit var school: String
    // Setiap penggunaan lateinit harus ada pengecekan apakah telah di inisialisasi
    fun isSchoolInitialized() = ::school.isInitialized
}

val Student.smartpants: String
get() {
    return "$name adalah murid pintar"
}

class Car(val name: String, val brand: String, val color: String) {
    var wheel: Int = 0

    val extraWheel: String
        get() {
            return "Pemesanan dengan tambahan ban extra sebanyak $wheel"
        }

    val pemesanan: String
        get() {
            return "Saya pesan $brand $name dengan warna $color"
        }

    companion object {
        var numberOfCars = 0
        var carColor = "Black"
    }

    var newCarIndent: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfCars++
        }
    }

    var orderedCar by Delegates.vetoable("Black")
    { _, _, newValue ->
        if (carColor == newValue) {
            println("We only sell black cars")
            false
        } else {
            true
        }
    }

    val notificationIndentCar: String by lazy {
        "Your requested car has been arrived. Pick up $brand $name at our dealership"
    }

    lateinit var stickerColor: String
}

val Car.indentCarColor: String
get() {
    return "Anda memesan mobil berwarna $color"
}

class Smartphone(val name: String, val brand: String, var storage: Int) {
    var memories: Int = 0
    var phoneInfo: String = ""
        get() {
            return "Smartphone ini adalah $brand $name"
        }

    companion object {
        var numberOfSmartphones = 0
        var maximumStorageAmount = 64
    }

    var newSmartphone: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfSmartphones++
        }
    }

    var orderedStorageAmount by Delegates.vetoable(0)
    { _, _, newValue ->
        if (newValue > maximumStorageAmount) {
            println("Smartphone with this amount of storage do not exist")
            false
        } else {
            true
        }
    }

    val deliverThePhone: String by lazy {
        "Delivering $brand $name to your house"
    }

    lateinit var case: String
}

val Smartphone.withCasing: String
get() {
    return "Pemesanan Smartphone ini menggunakan case"
}


class Doctor(val name: String, val specialization: String) {
    var age: Int = 0
    var isAvailable: Boolean = false
    var hospital: String = "Rumah Sakit"
        get() {
            return "Di $field ini terdapat $name spesialis $specialization"
        }

    companion object {
        var numberOfDoctors = 0
        var numberOfHospitalChanged = 0
        var maximumDoctorAge = 60
    }

    var newDoctorAdded: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfDoctors++
        }
    }

    var howManyHospitalChanged: Boolean by
    Delegates.observable(false) { _, oldValue, newValue ->
        if (newValue) {
            numberOfHospitalChanged++
        }
    }

    var doctorsAge by Delegates.vetoable(0)
    { _, _, newValue ->
        if (newValue > maximumDoctorAge) {
            println("$name is too old to practice in this hospital")
            false
        } else {
            true
        }
    }

    val callTheDoctor: String by lazy {
        "Calling $name right now"
    }

    lateinit var alumni: String
}

val Doctor.credibility: String
get() {
    return "$name adalah"
}