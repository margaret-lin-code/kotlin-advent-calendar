package aoc_2022

import java.io.File

fun main() {
    val input = File("src/main/resources/aoc_2022/day06_input.txt").readText()
    println(part1(input))
    println(part2(input))

}
fun solution(input: String, length: Int) = input.windowed(length)
    .indexOfFirst { it.toSet().size == length } + length

private fun part1(input: String) = solution(input, 4)

private fun part2(input: String) = solution(input, 14)