import java.util.*
import kotlin.math.sqrt

class Solution2558 {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(gifts.size) { a, b -> a-b}
        gifts.forEach {pq.offer(it)}
        repeat(k) { pq.offer(sqrt(pq.poll().toDouble()).toInt()) }
        return pq.sumOf { it.toLong() }
    }
}
