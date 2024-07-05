class Solution826 {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobs = profit.foldIndexed(mutableListOf<Pair<Int, Int>>()) { i, r, p -> r.add(difficulty[i] to p); r }
        worker.sort()
        jobs.sortBy { it.first }
        var i = 0
        var best = 0
        val n = profit.size
        return worker.sumOf { a ->
                                    while (i < n && a >= jobs[i].first) best = maxOf(best, jobs[i++].second)
                                    best
                }
    }
}

