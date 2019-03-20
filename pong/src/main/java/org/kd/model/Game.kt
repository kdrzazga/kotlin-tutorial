package org.kd.model

import org.kd.common.GraphOutput
import org.kd.common.ControlInput

class Game( private var output: GraphOutput) : Thread() {

    lateinit var board: Board//init in factory
    private var running: Boolean = false

    override fun run() {

        while (true) {
            sleep(20)
            moveBall()
            if (running)
                checkCollisions()
            draw()
        }
    }

    private fun draw() {
        output.draw(board)
        output.draw(board.redBat)
        output.draw(board.blueBat)
        output.draw(board.ball)
    }

    fun startGame() {
        this.running = true
        output.writeGameStarted()
    }

    fun isRunning(): Boolean {
        return running
    }

    private fun stopGame() {
        this.running = false
        output.writeGameOver()
    }

    private fun moveBall() {
        board.moveBall(this.running)
    }

    private fun checkCollisions() {
        if (this.running) {
            if (board.detectRedBatDeflection() || board.detectBlueBatDeflection())
                board.deflectBallVertically()
            else
                if (board.detectVerticalDeflection())
                    score()
        }
    }

    private fun score() {
        board.resetBall()
        stopGame()
    }
}