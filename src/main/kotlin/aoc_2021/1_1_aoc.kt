package aoc_2021

import loadInput

fun main() {
    val sonarValues = loadInput("aoc_2021/1_input").map { it.toInt() }

    var counter = 0

    for (index in 1 until sonarValues.size) {
        val previousValue = sonarValues[index-1]
        val currentValue = sonarValues[index]

        if (currentValue > previousValue) counter++
    }

    println(counter)
}