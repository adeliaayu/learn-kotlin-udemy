package section22.exception

/*
    1. KickBoxer class
    2. stamina
    3. punch power
    4. punch speed
    5. kick power
    6. kick speed
    7. Custom Exceptions
    8. Handle All Exception
    9. Finally Block
    10. Launch the Game
 */

fun main() {

    val myKickBoxer = KickBoxer()
    MuayThaiOrganizer.checkKickBoxer(myKickBoxer)
}

class KickBoxer {
    var stamina : Int = 0
    var punchPower: Int = 10
    var punchSpeed: Int = 20
    var kickPower: Int = 30
    var kickSpeed: Int = 40

    fun fight() {
        if (stamina < 50) {
            throw BoxerStaminaException()
        }
        if ((punchPower + punchSpeed) < 150) {
            throw PunchException()
        }
        if ((kickPower + kickSpeed) < 200) {
            throw KickException()
        }
        println("The fight is started. Let's go")
    }

    fun increaseStamina(stamina: Int) {
        this.stamina += stamina
        println("Increase Kick Boxer Stamina")
    }

    fun increasePunch(punchPower: Int, punchSpeed: Int) {
        this.punchPower += punchPower
        this.punchSpeed += punchSpeed
        println("The kick boxer's punch power and speed is increased")
    }

    fun increaseKick(kickPower: Int, kickSpeed: Int) {
        this.kickPower += kickPower
        this.kickSpeed += kickSpeed
        println("The kick boxer's kick power and speed is increased")
    }
}

object MuayThaiOrganizer {

    fun checkKickBoxer(kickBoxer: KickBoxer) {

        try {
            kickBoxer.fight()
        } catch (staminaBoxerException: BoxerStaminaException) {

            println(staminaBoxerException.message)
            kickBoxer.increaseStamina(100)

        } catch (punchException: PunchException) {

            println(punchException.message)
            kickBoxer.increasePunch(50, 50)

        } catch (kickException: KickException) {

            println(kickException.message )
            kickBoxer.increaseKick(50, 50)

        } finally {
            println("Good Luck!")
        }
    }
}

class BoxerStaminaException : Exception("Not enough stamina, drink this energy drink")
class PunchException : Exception("Not enough punch power and speed, practice your punch more")
class KickException : Exception("Not enough kick power and speed, practice your kick more")
