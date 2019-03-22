package org.kd.kd.tutorial

val strings = arrayOf("January", "February", "March")

val integers = intArrayOf(1, 2, 3, 4)

val array = arrayOfNulls<Number>(5)

val generatedStringArray = Array(10) { i -> "Number of index: $i"  }


fun main(args: Array<String>) {
    strings.forEach {
        print("${it}, ")
    }

    integers.forEach {
        print("${it}, ")
    }

    array.forEach {
        print("${it}, ")
    }

    generatedStringArray.forEach {
        print("${it}, ")
    }

}