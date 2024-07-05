import java.util.PriorityQueue

class Solution857 {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {

        val workers =  quality.foldIndexed(Array(quality.size){0.0 to 0.0}) { i, r, q ->
                                    r[i] = wage[i].toDouble()/q.toDouble() to q.toDouble() ;r }
                              .sortedBy { it.first }

        val pq = PriorityQueue<Double> { a, b -> (b - a).toInt() }
        var pqSum = 0.0

        return workers.fold(Double.MAX_VALUE) { r, w ->
            pqSum += w.second .also { pq.add(it) }
            if (pq.size > k) pqSum -= pq.poll()
            if (pq.size == k) minOf(pqSum*w.first, r) else r }
    }

}

