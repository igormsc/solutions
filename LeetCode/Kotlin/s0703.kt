import java.util.*

class KthLargest(k: Int, nums: IntArray) {

    private val pq = PriorityQueue<Int>()
    private var k = 0

    init {
        this.k = k
        nums.forEach { n ->
            pq.add(n)
            if (pq.size > k) pq.poll()
        }
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > k) pq.poll()
        return pq.first()
    }
}
