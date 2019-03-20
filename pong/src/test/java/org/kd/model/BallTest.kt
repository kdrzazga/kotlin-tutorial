package org.kd.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BallTest {

    @Test
    fun testBallMove() {
        val ball = Ball(50.0, 60.0)
        ball.move(1.0)
        assertEquals(51.41, ball.x, 0.5)
        assertEquals(61.41, ball.y, 0.5)
    }
}
