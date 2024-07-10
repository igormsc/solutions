import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inp = reader.readLine().split(" ").map{it.toInt()}
    val (n, m) = inp[0] to inp[1]
    val ask = reader.readLine().split(" ").map{it.toInt()}.toIntArray()
    val bid = reader.readLine().split(" ").map{it.toInt()}.toIntArray()
    reader.close()

    ask.sort()
    bid.sortDescending()
    val r = (0..<minOf(n,m)).sumOf { (bid[it] - ask[it]).let { if (it > 0) it.toLong() else 0L } }

    writer.write(r.toString())
    writer.newLine()
    writer.close()
}