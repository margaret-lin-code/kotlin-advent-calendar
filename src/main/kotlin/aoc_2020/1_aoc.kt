fun main() {
    // 1. read 1_input file
    // separate each line as int
    // assumption: all are int

    val inputList = loadInput("aoc_2020/1_input").map { line -> line.toInt() }

    // 2. find the pair for 2020
    var result1 = 0
    var result2 = 0
    var result3 = 0
    inputList.forEachIndexed { index, element ->
        val number1 = element
        for (index2 in index + 1 until inputList.size) {
            val number2 = inputList[index2]
            for (index3 in index2 + 1 until inputList.size) {
                val number3 = inputList[index3]
                val sum = number1 + number2 + number3

                if (sum == 2020) {
                    println("$number1 + $number2 + $number3 = 2020")
                    result1 = number1
                    result2 = number2
                    result3 = number3
                    break
                }
            }


        }
    }

    // 3. multiply the pair -> result
    val answer = result1 * result2 * result3
    println(answer)
}
