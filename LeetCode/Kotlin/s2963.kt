class Solution2963 {

    fun countBlocks(nums: BigArray): Int = f(nums, 0, nums.size() - 1)

    private fun f(nums: BigArray, l: Long, r: Long): Int {
        if (nums.at(l) == nums.at(r)) return 1
        val m = (l + r) shr 1
        val (a, b) = f(nums, l, m) to f(nums, m + 1, r)
        return a + b - (if (nums.at(m) == nums.at(m + 1)) 1 else 0)
    }

    abstract class BigArray(el: IntArray) {
        abstract fun at(i: Long): Int
        abstract fun size(): Long
    }

}