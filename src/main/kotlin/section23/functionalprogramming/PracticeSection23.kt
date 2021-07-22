package section23.functionalprogramming

import kotlin.random.Random

/*
    Functional Programming

    OOP -> Classes -> Instances -> Properties & Methods

    Functional Programming -> Functions -> Side Effects

    Side Effects - Changing state of systems
    ex: print something to the console or changing property value

    Referential Transparency - Input akan selalu sama dengan output
                             - Function yang menerapkan ini disebut Pure Function

    Function in Functional Programming - Mathematical NameSake Function

    First Class functions
     - Arguments
     - Return
     - Assign

    Higher Order Functions
     - Parameter
     - Return Value
 */


fun main() {

    // Coding in Functional Programming
    val boxerA = Boxer("John")
    val boxerB = Boxer("Jack")

    val onFightFinished = { boxingWinner: Boxer ->                  // Lambda in Functional Programming

        Referee.sendMessage(boxingWinner.name + " won the fight!")
    }

    BoxingArena.startTheFight(boxerA, boxerB, onFightFinished)      // Lambda in Functional Programming

    BoxingArena.startTheFight(boxerA, boxerB, ::fightFinished)      // Functions As Argument

    BoxingArena.startTheFight(boxerA, boxerB) {

        Referee.sendMessage("${it.name} won the fight!")
    }
}

fun fightFinished(boxer: Boxer) {
    Referee.sendMessage(boxer.name + " won the fight!!!")
}

class Boxer(val name: String) {

    var punchPower: Int = 0
    var punchSpeed: Int = 0

    private var healthAmount: Int = 200

    fun coachMessage(message: String) {
        println(message)
    }

    init {
        punchPower = punchPower + 150
        punchSpeed = punchSpeed + 100

        coachMessage("Added punch power: $punchPower and punch speed: $punchSpeed")
    }

    // properties or methods for fighting

    var canBoxerFight: Boolean = true

    fun throwPunch(boxer: Boxer) {
        val damageAmount = punchPower * punchSpeed * 0.2
        boxer.damageEnemy(damageAmount)
    }

    fun damageEnemy(damageAmount: Double) {

        val punchBlocked: Boolean = Random.nextBoolean()
        if (punchBlocked) {
            coachMessage("The enemy has blocked the punch. Try again")
            return
        }

        val punchMissed: Boolean = Random.nextBoolean()
        if (punchMissed) {
            coachMessage("The punch is missed. Try Again")
            return
        }

        healthAmount -= damageAmount.toInt()
        coachMessage("The damage is: $damageAmount - The health is: $healthAmount")

        if (healthAmount <= 0) {
            canBoxerFight = false
        }
    }
}

object BoxingArena {

    fun fight(boxerA: Boxer, boxerB: Boxer) {
        boxerA.throwPunch(boxerB)
        if (boxerB.canBoxerFight.not()) {
            return
        }

        boxerB.throwPunch(boxerA)
        if (boxerA.canBoxerFight.not()) {
            return
        }

        fight(boxerA, boxerB)       // Recursive function - memanggil kembali function didalam function
    }

    fun startTheFight(boxerA: Boxer, boxerB: Boxer) {

        var fightWinner: Boxer? = null
        fight(boxerA, boxerB)

        fightWinner = if (boxerA.canBoxerFight) boxerA else boxerB
        println(fightWinner.name)
    }

    fun startTheFight(boxerA: Boxer, boxerB: Boxer, onFightFinished: (Boxer) -> Unit) {

        var fightWinner: Boxer? = null

        fight(boxerA, boxerB)

        fightWinner = if (boxerA.canBoxerFight) boxerA else boxerB
        // println(fightWinner.name)

        onFightFinished(fightWinner)
    }
}

object Referee {

    fun sendMessage(message: String) {
        println(message)
    }
}

// Returning Function
fun tellMeYourAge(): (Int) -> Int {

    return ::randomAge
}

fun randomAge(until: Int) : Int {

    val randAge = Random.nextInt(until)
    return randAge
}