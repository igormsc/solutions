import java.io.BufferedReader
import java.io.InputStreamReader

// 84. Пирамида

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val blocks = (1..n).fold(Array(n){LongArray(2)}) { r, i -> r[i-1] = reader.readLine().trim().split(' ').map(String::toLong).toLongArray(); r}
    reader.close()

    blocks.sortWith(compareBy { it[0] })
    var max = blocks[0][1]
    var sum = 0L
    (1..blocks.lastIndex).forEach { i ->
        val (w,h) = blocks[i]
        if (w>blocks[i-1][0]) {
            sum += max
            max = h
        } else max = maxOf(h,max)
    }
    sum += max
    println(sum)
}