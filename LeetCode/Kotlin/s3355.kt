class Solution3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val ln = IntArray(nums.size+1)
        queries.forEach{
            ln[it[0]]++
            ln[it[1]+1]--
        }
        val ps = ln.runningReduce(Int::plus)
        return (0..nums.lastIndex).find { nums[it] > ps[it] } == null

    }

}
