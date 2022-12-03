import java.io.File
import java.io.InputStream
import java.math.BigInteger
import java.security.MessageDigest


fun loadInput(fileName: String): List<String> {
    val inputStream: InputStream = File("src/main/resources/$fileName").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    return inputString.split("\n")
}

fun readInputs(name: String): List<String> = File("src/main/resources", "$name.txt")
    .readLines()

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/main/resources", "$name")
    .readLines()


fun readInputByText(name: String) = File("src/main/resources", "$name").readText()
/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')