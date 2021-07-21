@file:JvmName("PersonExtensions")

package section21.kotlinandjavaoperability

import Person
val Person.personFullDescription: String
    get() = "$name - $hobbie - ${personJob.name}"

fun Person.returnDepositMoneyOfPerson(money: Int) {
    depositMoney = money
}