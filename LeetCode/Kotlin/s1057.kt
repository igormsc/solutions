import kotlin.math.absoluteValue

class Solution1057 {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        val (n, m) = workers.size to bikes.size
        val arr = Array(m * n) { IntArray(3) }
        var (i, k) = 0 to 0
        while (i < n) {
            for (j in 0..<m)
                arr[k++] = intArrayOf((workers[i][0] - bikes[j][0]).absoluteValue + (workers[i][1] - bikes[j][1]).absoluteValue, i, j)
            i++
        }
        arr.sortWith { a: IntArray, b: IntArray ->
            when {
                a[0] != b[0] -> a[0] - b[0]
                a[1] != b[1] -> a[1] - b[1]
                else -> a[2] - b[2]
            }
        }
        val (vis1, vis2) = BooleanArray(n) to BooleanArray(m)
        val res = IntArray(n)
        for (e in arr) {
            val (u, v) = e[1] to e[2]
            if (!vis1[u] && !vis2[v]) {
                vis1[u] = true
                vis2[v] = true
                res[u] = v
            }
        }
        return res
    }

}