import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var line = reader.readLine()
    val m = mutableMapOf<String,Int>()
    while (line != null) {
        val words = line.split(" ").filter { it.isNotBlank() }
        words.forEach { m[it] = (m[it]?:0) + 1 }
        line = reader.readLine()
    }

    val max = m.values.max()
    val r = m.filterValues { it == max }.keys.min()

    reader.close()

    writer.write(r)
    writer.newLine()
    writer.close()
}