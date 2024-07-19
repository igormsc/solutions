import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

// 93. Город Че

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, dist) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = reader.readLine().trim().split(' ').map(String::toLong).toLongArray()
    reader.close()
    val distL = dist.toLong()
    var cnt = 0L
    var r = 0
    (0..<n).forEach { l ->
        while (r<n && (nums[r] - nums[l]).absoluteValue <= distL) r++
        cnt += (n - r).toLong()
    }
    println(cnt)
}