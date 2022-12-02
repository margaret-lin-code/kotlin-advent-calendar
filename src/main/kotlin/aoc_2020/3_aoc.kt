package aoc_2020

import loadInput

// https://adventofcode.com/2020/day/3

fun main() {
    val map = loadInput("aoc_2020/3_input")

    // 1. load map
    // counter = 0
    // position = 3
    var counter = 0
    var position = 3

    // 2. in each line check for #
    // for each line in map
    //      skip first line
    //      line = current line
    //      position = calculatePosition() <- 2.1
    //      check if line.posHasTree(position): counter++ <- 2.2

    for (index in 1 until map.size) {
        val line = map[index]
        if (isTree(position, line)) counter++
        position += 3
    }

    // 3. print counter
    println(counter)
}

fun isTree(position: Int, line: String): Boolean {
    val toCheck = position % line.length
    return line[toCheck] == '#'
}


// 2.1: calculate position
// newPosition = previousPosition + 3

// 2.2: find if position on line has a tree
// line = current line from map in loop
// position = calculatePosition() % line.length
// isTree = line[position] == #
// return isTree
