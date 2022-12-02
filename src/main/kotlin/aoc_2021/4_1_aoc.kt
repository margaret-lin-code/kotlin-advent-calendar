package aoc_2021

import loadInput

fun main() {
    val bingo = loadInput("aoc_2021/4_input")

    val inputs = bingo[0].split(",").map { it.toInt() }

    val boards = createBoards(bingo)

    // go to each input and check update() from Board
    for (number in inputs) {
        for (board in boards) {
            board.update(number)
            if (board.validate()) {
                println(board.sumUnmarked() * number)
                return
            }
        }
    }
}

fun createBoards(bingo: List<String>): List<Board> {
    return emptyList()
}

data class Board(val cells: List<List<Cell>>) {
    fun update(num: Int) {
        //
    }

    fun validate(): Boolean {
        return true
    }

    fun sumUnmarked(): Int {
        return cells
            .flatten()
            .filter { !it.isSet }
            .sumOf { it.num }
    }
}

data class Cell(val num: Int, var isSet: Boolean)
