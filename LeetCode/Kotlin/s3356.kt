class Solution3356 {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {

        fun isZeroArray(j: Int): Boolean {
            val ln = IntArray(nums.size+1)
            (0..<j).forEach {
                ln[queries[it][0]] += queries[it][2]
                ln[queries[it][1]+1] -= queries[it][2]

            }
            val ps = ln.runningReduce(Int::plus)
            return (0..nums.lastIndex).find { nums[it] > ps[it] } == null
        }

        var (l, r) = 0 to queries.size+1
        while (l<r) {
            val m = (l+r)/2
            if (isZeroArray(m)) r = m else l = m + 1
        }
        return if (l > queries.size) -1 else l
    }
}
