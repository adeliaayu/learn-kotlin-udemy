package section22.exception

/*
    Exception
    1. Ketika inputan yang dibutuhkan INT tapi user memasukkan STRING maka exception dibutuhkan
    2. Exception used when there is something wrong
    3. Exception and Error adalah turunan Throwable jadi kita bisa throw untuk notify program

    Implement Exception
    1. Catch
    2. Fix - so it will not happen in the first place

    Fix -> Error - must be fixed, can't be catch

    Stacktrace
    1. Ketika terjadi exception, maka stacktrace akan mencetak exception tersebut dan pesan yang dibawanya
    2. Bertujuan untuk membantu kita menemukan eror/exception yang terjadi
 */

fun main() {
    multiply(5, 2)

    val myBoxer = Boxer()
    Referee.checkBoxer(myBoxer)
}

fun multiply(fNumber: Int, sNumber: Int) : Int {
    return secondMultiply(fNumber, sNumber)
}

fun secondMultiply(fNumber: Int, sNumber: Int): Int {
    return thirdMultiply(fNumber, sNumber)
}

fun thirdMultiply(fNumber: Int, sNumber: Int): Int {

//    throw Exception("An unexpected Exception")          // ketika throw, maka akan liat implementnya apakah ada handler dan begitu selanjutnya
    return 0
}


class Boxer {

    var stamina: Int = 100
    var punchPower: Int = 110
    var punchSpeed: Int = 120

    fun fight() {
        if (stamina < 50) {

            // throw Exception("Sorry.Not enough stamina. The fight is canceled")

            throw StaminaException()
        }

        if (punchPower < 70) {

            //  throw Exception("Sorry.Not enough punch power. The fight is canceled")

            throw PunchPowerException()
        }

        if (punchSpeed < 90) {

            //   throw Exception("Sorry.Not enough punch speed. The fight is canceled")

            throw PunchSpeedException()

        }

        println("The fight is started. Let's go")
    }

    fun increaseStamina(stamina: Int) {

        this.stamina += stamina
        println("The boxer's stamina is increased")

    }
    fun increasePunchPower(punchPower: Int) {

        this.punchPower += punchPower
        println("The boxer's punch power is increased")

    }

    fun increasePunchSpeed(punchSpeed: Int) {

        this.punchSpeed += punchSpeed
        println("The boxer's punch speed is increased")

    }
}

object Referee {

    fun checkBoxer(boxer: Boxer) {

        try {
            boxer.fight()
        } catch (staminaException: StaminaException) {

            println(staminaException.message)
            boxer.increaseStamina(100)

        } catch (punchPowerException: PunchPowerException) {

            println(punchPowerException.message)
            boxer.increasePunchPower(100)

        } catch (punchSpeedException: PunchSpeedException) {

            println(punchSpeedException.message )
            boxer.increasePunchSpeed(100)

        } finally {

            println("Good Luck!")

        }
    }
}

// Custom Exceptions
class StaminaException : Exception("Sorry.Not enough stamina. The fight is cancelled")
class PunchPowerException : Exception("Sorry.Not enough punch power. The fight is cancelled")
class PunchSpeedException : Exception("Sorry.Not enough punch speed. The fight is cancelled")
