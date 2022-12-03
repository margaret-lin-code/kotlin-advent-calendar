package aoc_2022

import aoc_2022.Gesture.*
import aoc_2022.Outcome.*
import readInput


/*
* this solution is credited to Sebastian from Advent of Code 2022 live stream
* */

fun main() {
    println(part1())
    println(part2())
}


var input = readInput("aoc_2022/day02_input.txt").map {
    val (a, b) = it.split(" ")
    a[0] to b[0]

    // [(A, Y), (B, X), (C, Z)]
}

fun part1(): Int {
    return input.sumOf { (opponent, you) ->
        calculateScore(opponent.toGesture(), you.toGesture())
    }
}

fun part2(): Int {
    return input.sumOf { (opponent, you) ->
        val yourHand = handForDesiredOutcome(opponent.toGesture(), you.toOutcome())
        calculateScore(opponent.toGesture(), yourHand)
    }
}


fun calculateScore(opponent: Gesture, me: Gesture): Int {
    val outcome = calculateOutcome(me, opponent)
    return me.points + outcome.points
}

enum class Outcome(val points: Int) {
    WIN(6),
    DRAW(3),
    LOSS(0)
}

fun calculateOutcome(first: Gesture, second: Gesture): Outcome = when {
    first == second -> DRAW
    first.beats() == second -> WIN
    else -> LOSS
}

fun handForDesiredOutcome(opponent: Gesture, desiredOutcome: Outcome): Gesture {
    return when (desiredOutcome) {
        DRAW -> opponent
        LOSS -> opponent.beats()
        WIN -> opponent.beatenBy()
    }
}

fun Gesture.beatenBy(): Gesture {
    return when (this) {
        SCISSORS -> ROCK
        ROCK -> PAPER
        PAPER -> SCISSORS
    }
}

fun Gesture.beats(): Gesture {
    return when (this) {
        ROCK -> SCISSORS
        PAPER -> ROCK
        SCISSORS -> PAPER
    }
}

fun Char.toGesture(): Gesture {
    return when (this) {
        'A', 'X' -> ROCK
        'B', 'Y' -> PAPER
        'C', 'Z' -> SCISSORS
        else -> error("Unknown input $this")
    }
}

fun Char.toOutcome(): Outcome {
    return when (this) {
        'X' -> LOSS
        'Y' -> DRAW
        'Z' -> WIN
        else -> error("Unknown input $this")
    }
}

enum class Gesture(val points: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}
