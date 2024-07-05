import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var line = reader.readLine()
    val s = mutableSetOf<String>()
    while (line != null) {
        s.addAll(line.split(" ").filter { it.isNotBlank() })
        line = reader.readLine()
    }
    reader.close()

    writer.write(s.size.toString())
    writer.newLine()
    writer.close()
}