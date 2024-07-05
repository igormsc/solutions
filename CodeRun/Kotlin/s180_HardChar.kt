import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val s = reader.readLine()
    val delays = reader.readLine().split(" ")
    reader.close()

    var max = Int.MIN_VALUE
    var prev = 0
    var i = 0
    delays.forEachIndexed{ j, d ->
        val curr = d.toInt()
        val delta = curr - prev
        if (delta == max) i = j
        if (delta > max) max = delta . also { i = j }
        prev = curr
    }

    writer.write(s[i].toString())
    writer.newLine()
    writer.close()
}