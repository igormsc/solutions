class Solution330 {
    fun minPatches(nums: IntArray, n: Int): Int {
        var sum = 0L
        val n = n.toLong()
        var cnt = 0
        var i = 0
        while (i < nums.size || sum < n) {
            val limit = if (i < nums.size) minOf(nums[i].toLong() - 1L, n) else n
            while (sum < limit) {
                sum += sum + 1
                cnt++
            }
            if (i < nums.size) sum += nums[i].toLong()
            i++
        }
        return cnt
    }
}
