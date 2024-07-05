class Solution2958 {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val frq = mutableMapOf<Int,Int>()
        var g = 0
        var j = 0
        nums.forEach { n ->
            frq[n] = (frq[n]?:0) + 1
            if (frq[n] == k+1) g++
            if (g != 0) {
                frq[nums[j]] = (frq[nums[j]]?:0) - 1
                if (frq[nums[j]] == k) g--
                j++
            }
        }
        return nums.size - j
    }
}

