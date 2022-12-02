package aoc_2021

import loadInput

fun main() {
    val table = loadInput("aoc_2021/3_input")

    var gamma = ""
    var epsilon = ""

    // 1. loop through the bit

    for (columnIndex in 0 until table[0].length) {
        var oneCounter = 0
        var zeroCounter = 0

        for (row in table) {
            if (row[columnIndex] == '1')
                oneCounter++
            else
                zeroCounter++
        }

        if (oneCounter > zeroCounter) {
            gamma = "1$gamma"
            epsilon = "0$epsilon"
        } else {
            gamma = "0$gamma"
            epsilon = "1$epsilon"
        }
    }

    val gammaDecimal = Integer.parseInt(gamma, 2)
    val epsilonDecimal = Integer.parseInt(epsilon, 2)
    println("gama: $gamma $gammaDecimal, epsilon: $epsilon $epsilonDecimal")
    println(gammaDecimal * epsilonDecimal)

    // 2. find out which bit (0/1) appear the most
    // 3. save the most appear bit -> gamma
    // 4. save the least appear bit -> epsilon
    // 5. convert binary gamma and epsilon to decimal
    // 6. multiply them and print
}