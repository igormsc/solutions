class Solution2563 {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()

        fun countLess(v: Int): Long {
            var res = 0L
            var (i,j) = 0 to nums.lastIndex
            while (i<j) {
                while (i<j && nums[i]+nums[j] > v) j--
                res += j - i++
            }
            return res
        }
        return countLess(upper) - countLess(lower-1)
    }

}
