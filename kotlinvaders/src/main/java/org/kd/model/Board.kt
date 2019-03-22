package org.kd.model

import java.util.function.Consumer

class Board(var sizeX: Double, var sizeY: Double) {

    lateinit var bat: Bat
    lateinit var aliens: HashSet<Alien>

    val batMoveStep: Int = 4

    fun moveAliens(gameRunning: Boolean) {
        if (gameRunning)
            aliens.forEach(Consumer { alien -> if (alien.y < bat.y) alien.move() })
    }

    fun enableAllAliens() {
        for (alien in aliens) {
            alien.alive = true
        }
    }

    //3 control functions below are called by REFLECTION
    fun fire() {
        bat.fire()
    }

    fun moveBatLeft() {
        if (bat.x > batMoveStep)
            bat.x -= batMoveStep
    }

    fun moveBatRight() {
        if (bat.x < sizeX)
            bat.x += batMoveStep
    }
}