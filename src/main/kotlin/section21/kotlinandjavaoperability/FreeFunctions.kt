package section21.kotlinandjavaoperability

import Person

fun returnPersonComputerName(person: Person, computerName: String) : String {
    return "${person.name} has a $computerName"
}