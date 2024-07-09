import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().split(" ").map { it.toInt() }.toSet()
    val b = reader.readLine().split(" ").map { it.toInt() }.toSet()
    reader.close()

    val r = a.intersect(b).sorted()
    writer.write(r.joinToString(" "))

    writer.close()
}