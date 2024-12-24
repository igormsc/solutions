class Solution2450 {
    fun countDistinctStrings(s: String, k: Int): Int = (0..s.length - k).fold(1) { r, _ -> (r * 2) % 1_000_000_007 }

}