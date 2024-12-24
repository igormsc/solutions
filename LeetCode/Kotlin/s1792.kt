import java.util.*

class Solution1792 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val pq = PriorityQueue { a: DoubleArray, b: DoubleArray -> ((b[0] + 1) / (b[1] + 1) - b[0] / b[1]).compareTo((a[0] + 1) / (a[1] + 1) - a[0] / a[1]) }
        classes.forEach { (a,b) -> pq.offer(doubleArrayOf(a.toDouble(), b.toDouble())) }
        repeat (extraStudents) {
            val (a, b) = pq.poll()
            pq.offer(doubleArrayOf(a+1, b+1))
        }
        var res = 0.0
        while (!pq.isEmpty()) {
            val (a,b) = pq.poll()
            res += a / b
        }
        return res / classes.size
    }
}
