class Solution719 {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        fun chk(m: Int): Boolean {
            var sum = 0
            var j = 1
            (0..nums.lastIndex).forEach { i ->
                while (j < nums.size && nums[j] - nums[i] <= m) j++
                j--
                sum += j - i
            }
            return sum >= k
        }
        nums.sort()
        var l = 0
        var r = nums.last() - nums.first()
        while (l <= r) {
            val m = (l + r) / 2
            if (chk(m)) r = m - 1 else l = m + 1
        }
        return l
    }

}