import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(' ').map(String::toLong)
    val nums = reader.readLine().trim().split(' ').map(String::toLong).toLongArray()
    reader.close()

    nums.sort()
    var l = 0L
    var r = (nums[0].absoluteValue + nums.last().absoluteValue) / k + 1

    while (l<r) {
        val m = (l+r)/2
        var cnt = 0L
        var maxR = nums[0] - 1
        nums.forEach{ if (it>maxR) maxR = it+m . also{cnt++} }
        if (cnt<=k) r = m else l = m+1
    }

    println(l)
}