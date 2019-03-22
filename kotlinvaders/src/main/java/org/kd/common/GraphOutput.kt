package org.kd.common

import org.kd.model.Alien
import org.kd.model.Bullet
import org.kd.model.Bat
import org.kd.model.Board

interface GraphOutput {

    fun draw(board: Board)

    fun draw(bullet: Bullet)

    fun draw(bat: Bat)

    fun draw(alien: Alien)

    fun writeControlsInfo()

    fun writeGameStarted()

    fun writeGameOver()
}
