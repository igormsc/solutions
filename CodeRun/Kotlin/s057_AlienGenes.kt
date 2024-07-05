import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val first = reader.readLine()
    val second = reader.readLine().windowed(2,1).toSet()
    reader.close()
    val r = first.windowed(2,1).count { second.contains(it) }

    writer.write(r.toString())
    writer.newLine()
    writer.close()
}