package org.kd.model

class Bat(var x: Double, var y: Double, var width: Double) {

    var bullet: Bullet = Bullet()

    fun fire() {
        bullet.fire(this.x, y)
    }
}
