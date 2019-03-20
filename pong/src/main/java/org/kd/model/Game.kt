package org.kd.model

import org.kd.common.GraphOutput
import org.kd.common.ControlInput

class Game(private var controlInput: ControlInput, private var output: GraphOutput) : Thread() {

    lateinit var board: Board//init in factory
    lateinit var input: Input
    private var running: Boolean = false

    override fun run() {

        while (true) {
            sleep(30)

            if (running)
                readInput()
            moveBall()

            if (running)
                checkCollisions()
            draw()
        }
    }

    fun draw() {
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

    fun stopGame() {
        this.running = false
        output.writeGameOver()
    }

    private fun moveBall() {
        board.moveBall(this.running)
    }

    private fun readInput() {
        //controlInput.getBoardMethod().invoke(board)
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