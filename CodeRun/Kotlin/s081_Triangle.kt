import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val t = (0..2).fold(mutableListOf<Int>()) { r, _ -> r.add(reader.readLine().toInt()); r}
    reader.close()

    val res = if (t[0] + t[1] > t[2] && t[0] + t[2] > t[1] && t[1] + t[2] > t[0]) "YES" else "NO"

    writer.write(res)
    writer.newLine()
    writer.close()
}