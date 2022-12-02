package aoc_2021

import loadInput

fun main() {
    val table = loadInput("aoc_2021/3_input")

    val o2 = reduceList(table) { zeroCounter: Int, oneCounter: Int -> oneCounter >= zeroCounter }
    val oxygenDecimal = Integer.parseInt(o2, 2)

    val co2 = reduceList(table) { zeroCounter: Int, oneCounter: Int -> zeroCounter > oneCounter }
    val co2Decimal = Integer.parseInt(co2, 2)

    println(oxygenDecimal * co2Decimal)
}

private fun reduceList(
    list: List<String>,
    predicate: (Int, Int) -> (Boolean)
): String {
    var resultList = list
    for (columnIndex in 0 until list.first().length) {
        if (resultList.size == 1) break

        val one = resultList.filter { it[columnIndex] == '1' }.size
        val zero = resultList.size - one

        resultList = if (predicate(zero, one)) {
            resultList.filter { it[columnIndex] == '1' }
        } else {
            resultList.filter { it[columnIndex] == '0' }
        }
    }
    return resultList.first()
}