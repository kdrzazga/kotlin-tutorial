package org.kd.model

class Bullet() : Thread() {

    var y: Double = 0.0
    var x: Double = 0.0

    val size: Double = 5.0
    var active: Boolean = false
    private var velocity: VelocityVector = VelocityVector(0.05, -Math.PI / 2)

    override fun run() {
        while (true) {

            if (active) {
                if (y > -30) {
                    y = velocity.moveY(y, 0.2)
                } else {
                    active = false
                }
            }
            Thread.sleep(Settings.bulletDelay)
        }
    }

    fun fire(batX: Double, boardHeight: Double) {
        if (!active) {
            x = batX
            y = boardHeight
            active = true
        }
    }
}
