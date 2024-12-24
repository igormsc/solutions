class Solution1842 {
    fun nextPalindrome(num: String): String {
        val nums = num.toCharArray()

        fun swap(i: Int, j: Int) {
            nums[i] = nums[j].also { nums[j] = nums[i] }
        }

        fun nextPermutation(): Boolean {
            val n = nums.size / 2
            var i = n - 2
            while (i >= 0 && nums[i] >= nums[i + 1]) i--
            if (i < 0) return false
            var j = n - 1
            while (j >= 0 && nums[i] >= nums[j]) j--
            swap(i++, j)
            j = n - 1
            while (i < j) swap(i++, j--)
            return true
        }

        if (!nextPermutation()) return ""
        val n = nums.size
        (0..<n / 2).forEach{ nums[n - 1 - it] = nums[it] }

        return String(nums)
    }

}