package aoc_2021

import loadInput

fun main() {
    val commands = loadInput("aoc_2021/2_input")

    var horizontal = 0
    var depth = 0

    for (command in commands) {
        val (action, value) = command.split(" ")

        when (action) {
            "forward" -> horizontal += value.toInt()
            "down" -> depth += value.toInt()
            "up" -> depth -= value.toInt()
        }
    }

    println(horizontal * depth)


    // 1. figure out the command
    // check the first char of the string
    // 2. add the corresponding value to depth or horizontal
    //  forward X increases the horizontal position by X units.
    //  down X increases the depth by X units.
    //  up X decreases the depth by X units.
    // 3. do this for every command in the list
    // 4. multiply depth and horizontal and print
}