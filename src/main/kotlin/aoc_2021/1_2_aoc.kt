package aoc_2021

import loadInput

fun main() {
    val sonarValues = loadInput("aoc_2021/1_input").map { it.toInt() }

    var counter = 0

    for (index in 0..sonarValues.size - 4) {
        val firstSum = sonarValues.sumValues(index)
        val secondSum = sonarValues.sumValues(index + 1)

        if (firstSum < secondSum) counter++
    }

    println(counter)
}

private fun List<Int>.sumValues(startIndex: Int): Int {
    return this[startIndex] + this[startIndex + 1] + this[startIndex + 2]
}