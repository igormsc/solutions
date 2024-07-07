import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 204. Ошибка

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val stat = (0..<n).fold(Array(n){0.0}) { r, i ->
        val inp = reader.readLine().split(" ").map { it.toDouble() }
        r[i] = inp[0] * inp[1] / 100
        r
    }
    reader.close()

    val errProb = 1 / stat.sum()
    val res = stat.map { it  * errProb }

    res.forEach {
        writer.write(it.toString())
        writer.newLine()
    }

    writer.close()
}