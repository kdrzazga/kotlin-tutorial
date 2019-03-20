package org.kd.model

class VelocityVector(private var speed: Double, var angle: Double) {

    fun moveX(x: Double, time: Double): Double {

        val distance = speed * time
        return x + distance * Math.cos(angle)
    }

    fun moveY(y: Double, time: Double): Double {

        val distance = speed * time
        return y + distance * Math.sin(angle)
    }

    fun deflectHorizontally() {
        angle = -angle
    }

    fun deflectVertically() {
        angle = Math.PI - angle
    }


}
