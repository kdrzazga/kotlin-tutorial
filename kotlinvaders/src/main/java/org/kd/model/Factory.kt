package org.kd.model

import org.kd.common.GraphOutput

object Factory {

    fun createGame(output: GraphOutput): Game {

        val game = Game(output)
        game.board = createBoard()

        return game
    }

    private fun createBoard(): Board {
        val board = Board(600.0, 400.0)
        board.bat = Bat(300.0, board.sizeY - 20, 60.0)
        board.aliens = HashSet()

        val distance = 50.0
        for (i in 0..Settings.numberOfAliens) {
            board.aliens.add(Alien(i, 70 + distance * i, 3 * distance, board))
        }

        return board
    }

}