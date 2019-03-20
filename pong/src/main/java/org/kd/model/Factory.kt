package org.kd.model

import org.kd.common.ControlInput
import org.kd.common.GraphOutput

object Factory {

    fun createGame(output: GraphOutput): Game {

        val game = Game(output)
        game.board = createBoard()

        return game
    }

    fun createBoard(): Board {
        val board = Board(600.0, 400.0)

        board.redBat = Bat(10.0, 300.0, 60.0, PongSide.RED)
        board.blueBat = Bat(590.0, 280.0, 60.0, PongSide.BLUE)

        board.ball = Ball(300.0, 200.0)

        return board
    }

}