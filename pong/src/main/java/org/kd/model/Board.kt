package org.kd.model

class Board(var sizeX: Double, var sizeY: Double) {

    lateinit var redBat: Bat
    lateinit var blueBat: Bat
    lateinit var ball: Ball

    val batMoveStep: Int = 4

    fun moveBall(gameRunning: Boolean) {
        ball.move(3.0)
        if (detectHorizontalDeflection()) ball.deflectHorizontally()
        if (!gameRunning && detectVerticalDeflection()) deflectBallVertically()
    }

    private fun detectHorizontalDeflection(): Boolean {
        return (ball.y <= ball.size) || (ball.y >= sizeY - ball.size)
    }

    fun detectVerticalDeflection(): Boolean {
        return (ball.x <= ball.size) || (ball.x >= sizeX - ball.size)
    }

    fun detectRedBatDeflection(): Boolean {
        return ball.x - ball.size / 2 < redBat.x
                && ball.y in redBat.y - redBat.height..redBat.y + redBat.height
    }

    fun detectBlueBatDeflection(): Boolean {
        return ball.x + ball.size / 2 > blueBat.x
                && ball.y in blueBat.y - blueBat.height .. blueBat.y + blueBat.height
    }

    fun deflectBallVertically() {
        ball.deflectVertically()
    }

    fun resetBall() {
        ball.reset()
    }

    //4 move functions below are used by REFLECTION
    fun moveRedBatUp() {
        if (redBat.y > batMoveStep)
            redBat.y -= batMoveStep
    }

    fun moveRedBatDown() {
        if (redBat.y < sizeY)
            redBat.y += batMoveStep
    }

    fun moveBlueBatUp() {
        if (blueBat.y > batMoveStep)
            blueBat.y -= batMoveStep
    }

    fun moveBlueBatDown() {
        if (blueBat.y < sizeY)
            blueBat.y += batMoveStep
    }
}