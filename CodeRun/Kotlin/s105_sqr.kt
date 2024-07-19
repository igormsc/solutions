import java.io.BufferedReader
import java.io.InputStreamReader

// 105. Площадь

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toLong()
    val m = reader.readLine().trim().toLong()
    val t = reader.readLine().trim().toLong()

    val sq = n*m
    var l = -1L
    var r = minOf(n,m)/2L + 1L
    while (r-l>1L) {
        val mid =(l+r)/2L
        val s = (n-mid*2L)*(m-mid*2L)
        if (sq-s <= t) l = mid else r = mid
    }
    println(if (l>-1L) l else 0L)
}
