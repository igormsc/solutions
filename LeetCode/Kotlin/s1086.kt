import java.util.*

class Solution1086 {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        var size = 0
        val s = Array<PriorityQueue<Int>?>(101) { null }
        val n = 5
        for (item in items) {
            val (i, score) = item
            if (s[i] == null) {
                size++
                s[i] = PriorityQueue<Int>(n)
            }
            s[i]!!.offer(score)
            if (s[i]!!.size > n) s[i]!!.poll()
        }
        val res = Array(size) { IntArray(2) }
        var j = 0
        for (i in 0..100)
            if (s[i] != null) {
                val avg = sum(s[i]) / n
                res[j][0] = i
                res[j++][1] = avg
            }
        return res
    }

    private fun sum(q: PriorityQueue<Int>?): Int {
        var s = 0
        while (q!!.isNotEmpty()) s += q.poll()
        return s
    }

}