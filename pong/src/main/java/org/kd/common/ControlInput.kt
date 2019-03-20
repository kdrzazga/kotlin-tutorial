package org.kd.common

import java.lang.reflect.Method

interface ControlInput {

    fun getBoardMethod(key: Char): Method?
}