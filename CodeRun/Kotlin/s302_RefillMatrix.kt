import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val taken = mutableSetOf<Int>()
    val matrix = (1..n).fold(mutableListOf<IntArray>()) { r, _ ->
        val row = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        row.forEach { taken.add(it) }
        r.add(row)
        r }
    reader.close()

    var next = 0
    fun nextNum(): Int {
        next++
        while (taken.contains(next)) next++
        return next
    }

    (0..<n).forEach { i ->
        (0..<n).forEach { j ->
            if (matrix[i][j] ==0 ) matrix[i][j] = nextNum() } }

    matrix.forEach { row ->
        writer.write(row.joinToString(" "))
        writer.newLine()
    }

    writer.close()
}