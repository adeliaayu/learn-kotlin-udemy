package section21.kotlinandjavaoperability

import Person

fun returnPersonComputerName(person: Person2, computerName: String) : String {
    return "${person.name} has a $computerName"
}