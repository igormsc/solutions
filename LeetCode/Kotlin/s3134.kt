class Solution3134 {
    fun medianOfUniquenessArray(nums: IntArray): Int {
        fun at(m: Long): Long {
            val cnt = mutableMapOf<Int, Int>()
            var i = 0
            return nums.indices.fold(0L) { r, j ->
                cnt[nums[j]] = (cnt[nums[j]] ?: 0) + 1
                while (cnt.size.toLong()>m) {
                    cnt[nums[i]] = (cnt[nums[i]] ?: 0) - 1
                    if (cnt[nums[i]] == 0) cnt.remove(nums[i])
                    i++
                }
                r + (j - i + 1).toLong()
            }
        }
        val n =nums.size.toLong()
        var l = 1L
        var r = n
        val total = n * (n+1)/2
        while (l<r) {
            val m = (l+r)/2
            if (at(m)*2 >= total) r = m else l = m+1
        }
        return l.toInt()
    }

}
