import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val tests = reader.readLine().trim().toInt()
    (0..<tests).forEach {
        reader.readLine()
        val r = reader.readLine().split(" ").map(String::toInt).sorted().windowed(2, 1).minOfOrNull { it[0].xor(it[1]) }!!
        writer.write(r.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}