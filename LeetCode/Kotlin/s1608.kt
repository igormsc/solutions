class Solution1608 {
    class Solution {
        fun specialArray(nums: IntArray): Int {
            val cnt = nums.fold(IntArray(102)) { r, n -> r[minOf(n, 100)]++; r }
            return (100 downTo 1).find { cnt[it] += cnt[it + 1]; cnt[it] == it } ?: -1
        }
    }
}

