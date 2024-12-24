class Solution974 {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val cnt = IntArray(k).also { it[0] = 1 }
        var pref = 0
        return nums.fold(0) { r, n ->
            pref = (pref + n % k + k) % k
            r + cnt[pref]++
        }
    }
}
