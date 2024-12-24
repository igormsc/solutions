class Solution3105 {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var inc = 1
        var dec = 1
        var prev = nums[0]
        return nums.drop(1).fold(1) { r, n ->
            if (n > prev) inc++.also { dec = 1 }
            else if (n < prev) dec++.also { inc = 1 }
            else {inc = 1; dec = 1}
            prev = n
            maxOf(r,maxOf(inc,dec))
        }
    }
}
