import java.util.*

class Solution3266 {
    val MOD = 1_000_000_007

    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val n = nums.size
        if (multiplier==1) return nums
        var mx = 0L
        val pq = PriorityQueue<Pair<Long,Int>> { a, b -> if (a.first == b.first) a.second - b.second else (a.first - b.first).toInt() }
        nums.forEachIndexed{ i, n -> pq.add(Pair(n.toLong(), i)); mx = maxOf(mx, n.toLong())}
        var k = k
        while (k>0 && pq.first().first*multiplier <= mx) {
            val p = pq.poll()
            pq.add(p.first*multiplier to p.second)
            k--
        }
        val arr = mutableListOf<Pair<Long,Int>>()
        while (pq.isNotEmpty()) arr.add(pq.poll())
        val times = k/n
        val v = pwr(multiplier.toLong(), times.toLong())
        k %= n
        val res = IntArray(n)
        arr.indices.forEach { i ->
            val cur = (arr[i].first*v)%MOD
            res[arr[i].second] = if (i<k) ((cur*multiplier)%MOD).toInt() else cur.toInt()
        }
        return res
    }

    private fun pwr(a: Long, b: Long): Long {
        var res = 1L
        var b = b
        var a = a
        while (b > 0) {
            if (b%2L==1L) res = (res*a)%MOD
            a = (a*a)%MOD
            b /=2L
        }
        return res
    }
}