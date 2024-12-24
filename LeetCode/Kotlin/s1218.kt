class Solution1218 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val m = mutableMapOf<Int,Int>()
        return (arr.reversed()).maxOf { a -> ((m[a+difference]?:0) + 1).also{m[a]=it} }
    }
}
