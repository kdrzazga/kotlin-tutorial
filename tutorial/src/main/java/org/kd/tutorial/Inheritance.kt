package org.kd.tutorial

open class Dog {                // Kotlin classes are final by default. If you want to allow the class inheritance, mark the class with the open modifier.
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("hau hau!")
    }
}

fun main(args: Array<String>) {
    val dog: Dog = Yorkshire()
    dog.sayHello()
}