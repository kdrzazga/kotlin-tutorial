package org.kd.view

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import org.kd.common.GraphOutput
import org.kd.model.Ball
import org.kd.model.Bat
import org.kd.model.Board
import org.kd.model.PongSide

class Drawer(private var gc: GraphicsContext) : GraphOutput {
    private val ballColor: Color = Color.GREEN
    private val backgroundColor: Color = Color.WHITE
    private val blueBatColor: Color = Color.BLUE
    private val redBatColor: Color = Color.RED
    private val boardColor: Color = Color.AQUAMARINE

    override fun writeGameOver() {
        println("\nGame over.\n")
        println("DEMO MODE. Press any key to start game.")
    }

    override fun writeGameStarted() {
        println("Game started")
    }

    override fun draw(ball: Ball) {
        gc.fill = ballColor
        gc.fillOval(ball.x - ball.size / 2, ball.y - ball.size / 2, ball.size, ball.size)
        gc.fill = backgroundColor
    }

    override fun draw(bat: Bat) {
        val batColor: Color = if (bat.pongSide == PongSide.BLUE)
            blueBatColor
        else redBatColor

        gc.fill = batColor
        gc.fillRect(bat.x - 2, bat.y - bat.height / 2, 4.0, bat.height)
        gc.fill = backgroundColor
    }

    override fun draw(board: Board) {
        val offset = 0.0
        gc.fill = boardColor
        gc.fillRect(offset, offset, board.sizeX - offset, board.sizeY - offset)
        gc.fill = boardColor
        gc.rect(0.0, 0.0, board.sizeX, board.sizeY)
    }

    override fun writeControlsInfo() {
        println("Welcome to PONG")
        println("Controls: a,z - Red Bat; p,l - Blue Bat")
        println("Demo mode. Press any key to start")
    }
}
