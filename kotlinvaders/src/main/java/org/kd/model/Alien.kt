package org.kd.model

class Alien(id: Int, var x: Double, var y: Double, val board: Board) {

    val size: Double = 18.0
    var alive: Boolean = false
    private var velocity: VelocityVector = VelocityVector(Math.abs(0.4 + 0.09 * id), 0.0)

    fun move() {
        if (alive) {
            x = velocity.moveX(x, 0.6)

            val offsetX = 32.0
            val offsetY = 30.0

            if (x > board.sizeX - offsetX || x < offsetX) {
                y += offsetY
                velocity.angle = if (velocity.angle == 0.0) Math.PI else 0.0
            }
        }
    }

    fun isHit(bullet: Bullet): Boolean {
        return x > bullet.x - bullet.size / 2 && x < bullet.x + bullet.size / 2
                && y > bullet.y - bullet.size / 2 && y < bullet.y + bullet.size / 2
    }

    fun kill(){
        alive = false
    }
}