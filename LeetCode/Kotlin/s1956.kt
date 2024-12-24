
import java.util.*
import kotlin.math.absoluteValue

class Solution1956 {
    fun minDayskVariants(points: Array<IntArray>, k: Int): Int {

        fun clc(x: Int, y: Int): Int {
            val pq = PriorityQueue(Collections.reverseOrder<Int>())
            points.forEach { p ->
                pq.add(((x - p[0]).absoluteValue + (y - p[1]).absoluteValue).absoluteValue)
                if (pq.size > k) pq.poll()
            }
            return pq.poll()
        }

        return (0..100).minOf{i -> (0..101).minOf{ j-> clc(i, j) }}
    }

}
