import java.io.File
import java.io.InputStream


fun loadInput(fileName: String): List<String> {
    val inputStream: InputStream = File("src/main/resources/$fileName").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    return inputString.split("\n")
}
