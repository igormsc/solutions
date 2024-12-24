import java.util.*

class Solution3377 {

    private var prime = BooleanArray(10002) { true }.also { it[0] = false; it[1] = false }

    init {
        for (i in 2..prime.lastIndex) {
            if (prime[i]) {
                var j = i * 2
                while (j < prime.size) {
                    prime[j] = false
                    j += i } } }
    }

    fun minOperations(n: Int, m: Int): Int {
        if (prime[n]) return -1
        val pq = PriorityQueue { a: IntArray, b: IntArray -> a[1] - b[1] }
        pq.offer(intArrayOf(n, n))
        val vis = IntArray(10002) { Int.MAX_VALUE }.also { it[n] = n }

        while (!pq.isEmpty()) {
            val (x, y) = pq.poll()
            if (x == m) return y
            val sb = StringBuilder(x.toString())
            for (i in sb.indices) {
                val c = sb[i]
                if (c != '9') {
                    sb.setCharAt(i, (c.code + 1).toChar())
                    val j = sb.toString().toInt()
                    if (j < prime.size && !prime[j] && y + j < vis[j]) {
                        vis[j] = y + j
                        pq.offer(intArrayOf(j, y + j)) }
                    sb.setCharAt(i, c) }
                if (c > '0') {
                    sb.setCharAt(i, (c.code - 1).toChar())
                    val j = sb.toString().toInt()
                    if (j < prime.size && !prime[j] && y + j < vis[j]) {
                        vis[j] = y + j
                        pq.offer(intArrayOf(j, y + j)) }
                    sb.setCharAt(i, c) }
            }
        }
        return -1
    }
}