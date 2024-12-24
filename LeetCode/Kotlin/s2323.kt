class Solution2323 {
    fun minimumTime(jobs: IntArray, workers: IntArray): Int {
        jobs.sort()
        workers.sort()
        return jobs.indices.maxOf { (jobs[it] + workers[it] - 1) / workers[it] }
    }

}