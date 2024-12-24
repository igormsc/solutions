class Solution995 {
    fun minKBitFlips(nums: IntArray, k: Int): Int =
        nums.indices.fold(0 to 0) { r, i ->
            (if (r.second%2 == nums[i]) {
                            if (i > nums.size - k) return -1
                            nums[i] -= 2
                        r.first + 1 to r.second + 1
                } else  r
            ).let {
             if (i >= k-1 && nums[i-k+1] < 0) {
                        nums[i-k+1] += 2
                        it.first to it.second - 1
                } else  it
            }
        }.first
}
