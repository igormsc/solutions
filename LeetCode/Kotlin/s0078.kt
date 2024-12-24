class Solution78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun sets(i: Int, sub: MutableList<Int>) {
            res.add(sub.toList())
            (i..nums.lastIndex).forEach {
                sub.add(nums[it])
                sets(it+1, sub)
                sub.removeLast()
            }
        }

        sets(0, mutableListOf())
        return res
    }
}
