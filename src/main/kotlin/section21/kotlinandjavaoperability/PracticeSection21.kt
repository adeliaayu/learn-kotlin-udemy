package section21.kotlinandjavaoperability

import Person

fun main(){

    // Mixing Code - Getter and Setter
    val myPerson1 = Person()
    myPerson1.name = "Joe"
//    println(myPerson)

    myPerson1.hobbie = "Yoga"
    println(myPerson1.hobbie)
//    println(myPerson)

    // Kotlin Class as Java Property
    val myPerson = Person2()
    myPerson.name = "Joe"
    val programmingJob = Job("iOS Developer", 2000, JobType.Freelance)
    myPerson.personJob = programmingJob
    println(myPerson.personJob)

    // Java Class extension Function
    myPerson.returnDepositMoneyOfPerson(2000)
    println(myPerson.depositMoney)

    // Free Functions - global function
    myPerson.computerName = "Macbook Pro"
    println(myPerson)

    // Java Nullability
    val myPerson2 = Person2()
    println(myPerson2.hobbie.length)
    myPerson2.hobbie = null
    println(myPerson2.hobbie?.length)

}