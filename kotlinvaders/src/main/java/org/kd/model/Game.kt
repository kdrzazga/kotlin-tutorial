package org.kd.model

import org.kd.common.GraphOutput
import java.util.function.Consumer
import java.util.function.Predicate

class Game(private var output: GraphOutput) : Thread() {

    lateinit var board: Board//init in factory
    private var running: Boolean = false

    override fun run() {
        board.bat.bullet.start()//starts thread, doesn't fire bullet

        while (true) {
            sleep(Settings.animationDelay)
            moveAliens()

            if (running)
                checkCollisions()
            draw()
        }
    }

    private fun draw() {
        output.draw(board)
        output.draw(board.bat)

        for (alien in board.aliens) {
            output.draw(alien)
        }

        output.draw(board.bat.bullet)
    }

    fun startGame() {

        this.running = true
        board.enableAllAliens()
        output.writeGameStarted()
    }

    fun isRunning(): Boolean {
        return running
    }

    private fun stopGame() {
        this.running = false

        output.writeGameOver()
    }

    private fun moveAliens() {
        board.moveAliens(this.running)
    }

    private fun checkCollisions() {
        if (this.running) {
            board.aliens.stream()
                    .filter { alien -> alien.isHit(board.bat.bullet)}
                    .forEach(Alien::kill)
        }
    }

    private fun score() {
        //TODO
    }
}