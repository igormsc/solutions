class Solution3277 {
    fun maximumSubarrayXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        val (n, m) = nums.size to queries.size
        val d: MutableMap<Int, MutableList<Int>> = HashMap()
        for (q in 0..<m) d.computeIfAbsent(queries[q][1] - queries[q][0]) { k: Int? -> ArrayList() }.add(q)

        val res = IntArray(m)
        val cur = nums.copyOf(n)
        for (v in 0..<n) {
            if (d.containsKey(v)) for (q in d[v]!!) res[q] = cur[queries[q][0]]
            for (i in 0..<n - v - 1) {
                nums[i] = nums[i] xor nums[i + 1]
                cur[i] = maxOf(cur[i], cur[i + 1], nums[i])
            }
        }
        return res
    }
}