package aoc_2021

import loadInput

fun main() {
    val commands = loadInput("aoc_2021/2_input")

    var horizontal = 0
    var depth = 0
    var aim = 0

    for (command in commands) {
        val (action, value) = command.split(" ")

        when (action) {
            "forward" -> {
                horizontal += value.toInt()
                depth += aim * value.toInt()
            }
            "down" -> aim += value.toInt()
            "up" -> aim -= value.toInt()
        }
    }

    println(horizontal * depth)
}