class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frq = tasks.fold(IntArray(255)) { f, t -> f[t.code]++;  f}
        val cnt = frq.max()
        val res = (cnt-1) * (n+1) + frq.count { it == cnt }
        return if (tasks.size > res) tasks.size else res
    }
}
