package aoc_2021

import loadInput

fun main() {
    val table = loadInput("aoc_2021/3_input").map { it.split("") }
    val tableTranspose = transposeTable(table)

    var gamma = ""
    var epsilon = ""

    for (row in tableTranspose) {
        val maxOne = row.filter { it == "1" }.size > row.size / 2

        if (maxOne) {
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
}

private fun transposeTable(table: List<List<String>>): Array<Array<String>> {
    val tableTranspose = Array(table.first().size) { Array(table.size) { "" } }
    for (rowIndex in table.indices) {
        for (columnIndex in table.first().indices) {
            tableTranspose[columnIndex][rowIndex] = table[rowIndex][columnIndex]
        }
    }
    return tableTranspose
}