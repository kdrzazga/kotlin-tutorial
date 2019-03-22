package org.kd

import javafx.application.Application
import org.kd.view.Main

class Kotlinvaders {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Main::class.java)
        }
    }
}