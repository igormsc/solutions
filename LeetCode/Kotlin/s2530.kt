import java.util.PriorityQueue

class Solution2530 {

    fun maxKelements(nums: IntArray, k: Int): Long {
        var res = 0L
        val pq = PriorityQueue<Int> (compareByDescending { it })
        nums.forEach { pq.add(it) }
        repeat(k) {
            val n = pq.poll()
            res += n.toLong()
            pq.add((n + 2) / 3)
        }
        return res
    }

}
