package org.kd.view

import org.kd.common.ControlInput
import org.kd.model.Board
import org.kd.model.Settings
import java.lang.reflect.Method
import java.util.*

class KeyInput : ControlInput {

    override fun getBoardMethod(key: Char): Method? {
        return try {
            val characterMethodMap = Hashtable<Char, Method>()

            characterMethodMap[Settings.moveLeftKey] = Board::class.java.getMethod("moveBatLeft")
            characterMethodMap[Settings.moveRightKey] = Board::class.java.getMethod("moveBatRight")
            characterMethodMap[Settings.fireKey] = Board::class.java.getMethod("fire")

            characterMethodMap[key.toLowerCase()]

        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
            null
        }
    }
}
