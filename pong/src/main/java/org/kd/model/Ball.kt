package org.kd.model

class Ball(var x: Double , var y: Double) {

    val size: Double = 15.0
    private var velocity: VelocityVector = VelocityVector(2.0, Math.PI / 4)

    fun move(time: Double) {
        x = velocity.moveX(x, time)
        y = velocity.moveY(y, time)
    }

    fun deflectVertically() {
        velocity.deflectVertically()
    }

    fun deflectHorizontally() {
        velocity.deflectHorizontally()
    }

    fun reset() {
        x = 300.0
        y = 200.0
    }
}
