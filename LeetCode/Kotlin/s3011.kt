class Solution3011 {
    fun canSortArray(nums: IntArray): Boolean {
        return nums.fold(intArrayOf(0, Int.MIN_VALUE, 0, 0, 0)) { r, n ->
            r[2] = n.countOneBits()
            if (r[2] != r[0]) {
                if (r[3] < r[1] || r[4] < r[1]) return false
                r[0] = r[2]
                r[1] = r[3]
                r[3] = n
                r[4] = n
            } else {
                r[3] = maxOf(r[3], n)
                r[4] = minOf(r[4], n) }
            r }.let { it[3] >= it[1] && it[4] >= it[1] }
    }
}