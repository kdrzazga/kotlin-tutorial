package org.kd.view

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import org.kd.common.GraphOutput
import org.kd.model.Ball
import org.kd.model.Bat
import org.kd.model.Board
import org.kd.model.PongSide

class Drawer(private var gc: GraphicsContext) : GraphOutput {

    private val BALL_COLOR: Color = Color.GREEN
    private val BACKGROUND_COLOR: Color = Color.WHITE
    private val BLUEBAT_COLOR: Color = Color.BLUE
    private val REDBAT_COLOR: Color = Color.RED
    private val BOARD_COLOR: Color = Color.AQUAMARINE

    override fun writeGameOver() {
        println("\nGame over.\n")
        println("DEMO MODE. Press any key to start game.")
    }

    override fun writeGameStarted() {
        println("Game started")
    }

    override fun draw(ball: Ball) {
        gc.fill = BALL_COLOR
        gc.fillOval(ball.x - ball.size / 2, ball.y - ball.size / 2, ball.size, ball.size)
        gc.fill = BACKGROUND_COLOR
    }

    override fun draw(bat: Bat) {
        val batColor: Color = if (bat.pongSide == PongSide.BLUE)
            BLUEBAT_COLOR
        else REDBAT_COLOR

        gc.fill = batColor
        gc.fillRect(bat.x - 2, bat.y - bat.height / 2, 4.0, bat.height)
        gc.fill = BACKGROUND_COLOR
    }

    override fun draw(board: Board) {
        val offset = 0.0
        gc.fill = BOARD_COLOR
        gc.fillRect(offset, offset, board.sizeX - offset, board.sizeY - offset)
        gc.fill = BOARD_COLOR
        gc.rect(0.0, 0.0, board.sizeX, board.sizeY)
    }

}
