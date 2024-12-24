import java.util.*

class Solution358 {
    fun rearrangeString(s: String, k: Int): String {
        val n = s.length
        val cnt = IntArray(26)
        for (c in s.toCharArray()) cnt[c.code - 'a'.code]++
        val pq = PriorityQueue { a: IntArray, b: IntArray -> b[0] - a[0] }
        for (i in 0..25)
            if (cnt[i] > 0) pq.offer(intArrayOf(cnt[i], i))

        val q = mutableListOf<IntArray>()
        val res = StringBuilder()
        while (pq.isNotEmpty()) {
            var p = pq.poll()
            val (v,c) = p
            res.append(('a'.code + c).toChar())
            q.add(intArrayOf(v - 1, c))
            if (q.size >= k) {
                p = q.removeFirst()
                if (p[0] > 0) pq.offer(p)
            }
        }
        return if (res.length == n) res.toString() else ""
    }

}