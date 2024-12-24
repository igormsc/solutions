class Solution1426 {
    fun countElements(arr: IntArray): Int {
        val cnt = arr.fold(IntArray(1001)) { r, c -> r[c]++; r}
        return (0..999).sumOf {if (cnt[it + 1] > 0) cnt[it] else 0}
    }

}