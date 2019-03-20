package org.kd.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VelocityVectorTest {

    @Test
    fun `Test vertical deflection`() {
        val vector1 = VelocityVector(100.0, Math.PI/4)
        vector1.deflectVertically()

        assertEquals(3*Math.PI/4, vector1.angle, 0.01)
    }
}