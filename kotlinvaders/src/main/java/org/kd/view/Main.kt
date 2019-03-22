package org.kd.view

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyEvent
import javafx.stage.Stage
import javafx.stage.WindowEvent
import org.kd.common.ControlInput
import org.kd.common.GraphOutput
import org.kd.model.Factory
import org.kd.model.Game

class Main : Application() {

    private val width = 630.0
    private val height = 500.0
    private var keyInput: ControlInput = KeyInput()
    private lateinit var game: Game

    override fun start(stage: Stage) {

        val output: GraphOutput = Drawer(initStage(stage))
        game = Factory.createGame(output)
        game.start()//starts the thread, but not the game
        output.writeControlsInfo()
    }

    private fun initStage(stage: Stage): GraphicsContext {
        val canvas = Canvas(width, height - 30)
        stage.maxWidth = width - 20
        stage.minWidth = width - 20
        stage.minHeight = height
        val gc = canvas.graphicsContext2D

        val root = Group()
        stage.scene = Scene(root)
        root.children.add(canvas)

        stage.onCloseRequest = exit()
        stage.scene.onKeyPressed = executeEventHandler()

        stage.show()
        return gc
    }

    private fun exit(): EventHandler<WindowEvent> {
        return EventHandler {
            System.exit(0)
        }
    }

    private fun executeEventHandler(): EventHandler<KeyEvent> {
        return EventHandler {

            if (!game.isRunning())
                game.startGame()
            else if (!it.text.isEmpty()) {
                val keyChar: Char = it.text[0]
                keyInput.getBoardMethod(keyChar)?.invoke(game.board)//? means if != null
            }
        }
    }
}