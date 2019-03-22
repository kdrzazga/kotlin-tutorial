package org.kd.view

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import org.kd.common.GraphOutput
import org.kd.model.Alien
import org.kd.model.Bat
import org.kd.model.Board
import org.kd.model.Bullet

class Drawer(private var gc: GraphicsContext) : GraphOutput {


    private val alienColor: Color = Color.LIGHTGREEN
    private val ballColor: Color = Color.YELLOW
    private val backgroundColor: Color = Color.BLACK
    private val batColor: Color = Color.RED
    private val boardColor: Color = Color.BLACK

    override fun writeGameOver() {
        println("\nGame over.\n")
        println("DEMO MODE. Press any key to start game.")
    }

    override fun writeGameStarted() {
        println("Game started")
    }

    override fun draw(bullet: Bullet) {
        gc.fill = ballColor
        gc.fillOval(bullet.x - bullet.size / 2, bullet.y - bullet.size / 2, bullet.size, bullet.size)
        gc.fill = backgroundColor
    }

    override fun draw(bat: Bat) {
        gc.fill = batColor
        drawIsoscelesTriangle(gc, bat.x, bat.y + 20, 20.0, 33.0)
        gc.fill = backgroundColor
    }

    override fun draw(alien: Alien) {
        if (alien.alive) {
            gc.fill = alienColor
            //gc.fillPolygon()
            gc.fillRect(alien.x - alien.size / 2, alien.y - alien.size / 2, alien.size, alien.size)
            gc.fill = backgroundColor
        }
    }

    override fun draw(board: Board) {
        val offset = 0.0
        gc.fill = boardColor
        gc.fillRect(offset, offset, board.sizeX - offset, board.sizeY - offset)
        gc.fill = boardColor
        gc.rect(0.0, 0.0, board.sizeX, board.sizeY)
    }

    private fun drawIsoscelesTriangle(gc: GraphicsContext, x: Double, y: Double, base: Double, h: Double) {
        val xVertices = doubleArrayOf(x - base / 2, x + base / 2, x, x - base / 2)
        val yVertices = doubleArrayOf(y, y, y - h, y)

        gc.fillPolygon(xVertices, yVertices, xVertices.size)
    }

    override fun writeControlsInfo() {
        println("Welcome to KOTLINVADERS")
        println("Controls: z,x - left,right f - fire")
        println("Press any key to start")
    }

}
