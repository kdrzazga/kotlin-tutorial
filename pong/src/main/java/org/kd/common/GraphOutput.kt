package org.kd.common

import org.kd.model.Ball
import org.kd.model.Bat
import org.kd.model.Board

interface GraphOutput {

    fun draw(board: Board)

    fun draw(ball: Ball)

    fun draw(bat: Bat)

    fun writeControlsInfo()

    fun writeGameStarted()

    fun writeGameOver()
}