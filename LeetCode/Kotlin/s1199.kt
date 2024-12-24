import java.util.*

class Solution1199 {
    fun minBuildTime(blocks: IntArray, split: Int): Int {
        val q = PriorityQueue<Int>()
        blocks.forEach{ q.offer(it) }
        while (q.size > 1) {
            q.poll()
            q.offer(q.poll() + split)
        }
        return q.poll()
    }

}