@file:JvmName("PersonExtensions")

package section21.kotlinandjavaoperability

import Person
val Person2.personFullDescription: String
    get() = "$name - $hobbie - ${personJob.name}"

fun Person2.returnDepositMoneyOfPerson(money: Int) {
    depositMoney = money
}