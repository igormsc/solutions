import java.io.BufferedReader
import java.io.InputStreamReader

// 116. Детский праздник

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    var (m, n) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = (0..<n).fold(Array(n){IntArray(3)}) {r, i ->
        val p = reader.readLine().trim().split(' ').map(String::toInt).toIntArray()
        r[i] = intArrayOf(p[0],p[1],p[0]*p[1]+p[2])
        r}
    reader.close()

    fun chk(x: Int): Boolean = nums.sumOf { (x/it[2]) * it[1] + minOf((x%it[2])/it[0],it[1]) } >= m

    var l = -1
    var r = 3_000_001
    while (r > l + 1) {
        val x = (l + r) / 2
        if (chk(x)) r = x else l = x
    }

    val res =
    nums.foldIndexed(IntArray(n)) { i, rl, v ->
        val cnt = (r/v[2])*v[1] + minOf((r%v[2])/v[0],v[1])
        rl[i] = minOf(cnt,m)
        m = maxOf(m - cnt, 0)
        rl}
    println(r)
    println(res.joinToString(" "))
}