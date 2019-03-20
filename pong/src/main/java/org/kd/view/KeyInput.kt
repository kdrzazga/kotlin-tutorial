package org.kd.view

import org.kd.common.ControlInput
import org.kd.model.Board
import java.lang.reflect.Method
import java.util.*

class KeyInput : ControlInput {

    override fun getBoardMethod(key: Char): Method? {
        try {
            val characterMethodMap = Hashtable<Char, Method>()

            characterMethodMap['a'] = Board::class.java.getMethod("moveRedBatUp")
            characterMethodMap['z'] = Board::class.java.getMethod("moveRedBatDown")
            characterMethodMap['p'] = Board::class.java.getMethod("moveBlueBatUp")
            characterMethodMap['l'] = Board::class.java.getMethod("moveBlueBatDown")

            return characterMethodMap.get(key.toLowerCase())

        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
            return null
        }
    }
}