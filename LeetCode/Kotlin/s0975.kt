import java.util.*

class Solution975 {
    fun oddEvenJumps(arr: IntArray): Int {
        val tm = TreeMap<Int, Int>()
        val n = arr.size
        val f = Array(n) { arrayOfNulls<Int>(2) }
        val g = Array(n) { IntArray(2) }

        for (i in arr.lastIndex downTo 0) {
            val hi = tm.ceilingEntry(arr[i])
            g[i][1] = if (hi == null) -1 else hi.value
            val lo = tm.floorEntry(arr[i])
            g[i][0] = if (lo == null) -1 else lo.value
            tm[arr[i]] = i
        }

        fun dfs(i: Int, k: Int): Int =
            when {
                i == n - 1 -> 1
                g[i][k] == -1 -> 0
                f[i][k] != null -> f[i][k]!!
                else -> dfs(g[i][k], k xor 1).also { f[i][k] = it }
            }

        return (0..<n).sumOf { dfs(it, 1) }
    }


}
