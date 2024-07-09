import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val line = reader.readLine().split(' ')
    val nums = line.filter { it.isNotBlank() }.map { it.toInt() }
    reader.close()

    val r = nums.fold(Pair(Int.MIN_VALUE, Int.MIN_VALUE) to Pair(Int.MAX_VALUE, Int.MAX_VALUE)) { (max, min), n ->
                when {
                    n > max.first -> Pair(n, max.first)
                    n > max.second -> Pair(max.first, n)
                    else -> max
                } to
                when {
                    n < min.first -> Pair(n, min.first)
                    n < min.second -> Pair(min.first, n)
                    else -> min
                }
    }.let { if (it.first.first.toLong() * it.first.second.toLong() > it.second.first.toLong() * it.second.second.toLong()) it.first else it.second }
        .let { minOf(it.first, it.second) to maxOf(it.first, it.second) }


    writer.write(r.toString().trim(')', '(').replace(",", ""))
    writer.close()
}