package aoc_2020

import loadInput

fun main() {
    // 1. Read the inputs and save into a list of password objects
    val passwords = loadInput("aoc_2020/2_input").map { createPasswords(it) }

    // 3. print number of valid passwords
    val validPasswords = passwords.filter { it.isValid }
    println("1: " + validPasswords.size)


    val validPasswords2 = passwords.filter { it.isValid2 }
    println("2: " + validPasswords2.size)
}

private fun createPasswords(input: String): Password {
    val fields = input.split("-", " ")

    return Password(fields[3], fields[2].replace(":", ""), fields[0].toInt(), fields[1].toInt())
}

data class Password(val password: String, val char: String, val min: Int, val max: Int) {
    val isValid: Boolean
        get() {
            // 2. count how many times the character appears based on min and max
            val range = min..max
            val countedChar = password.split("").filter { it.equals(char) }.size
            return countedChar in range
        }

    val isValid2: Boolean
        get() {
            val firstPosition = password[min - 1].toString() == char
            val secondPosition = password[max - 1].toString() == char
            val atBothPositions = firstPosition && secondPosition

            return !atBothPositions && (firstPosition || secondPosition)
        }
}