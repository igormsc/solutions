import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val res = reader.readLine().split(' ').map { it.toInt() }.sorted()[1]
    reader.close()

    writer.write(res.toString())
    writer.close()
}