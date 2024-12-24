import kotlin.math.absoluteValue

class Solution1066 {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        val (n, m) = workers.size to bikes.size
        val f = Array(n + 1) { IntArray(1.shl(m)) { Int.MAX_VALUE / 2 } }.also{it[0][0] = 0}
        for (i in 1..n)
            for (j in 0..<1.shl(m))
                for (k in 0..<m)
                    if ((j.shr(k).and(1)) == 1) {
                        val d = (workers[i - 1][0] - bikes[k][0]).absoluteValue + (workers[i - 1][1] - bikes[k][1]).absoluteValue
                        f[i][j] = minOf(f[i][j], (f[i - 1][j.xor(1.shl(k))] + d)) }
        return f[n].min()
    }

}