package org.kd.view

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.stage.Stage
import org.kd.model.Factory
import org.kd.model.Game


class Pong : Application() {

    private lateinit var game: Game

    override fun start(stage: Stage) {

        var gc = initStage(stage)
        game = Factory.createGame(KeyInput(), Drawer(gc))
        game.start()//starts the thread, but not the game
        println("Welcome to PONG")
        println("Demo mode. Press any key to start")
    }

    private fun initStage(stage: Stage): GraphicsContext {
        var canvas = Canvas(630.0, 470.0)
        val gc = canvas.graphicsContext2D
        var root = Group()
        stage.scene = Scene(root)

        root.children.add(canvas)

        stage.onCloseRequest = EventHandler {
            System.exit(0)
        }
        stage.scene.onKeyPressed = EventHandler {
            //if (it.character == " ")
            if (!game.isRunning())
                game.startGame()

        }

        stage.show()
        return gc
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Pong::class.java)
        }
    }
}