class Solution340 {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val cnt = mutableMapOf<Char, Int>()
        var l = 0
        val cs = s.toCharArray()
        for (c in cs) {
            cnt.merge(c, 1) { a: Int, b: Int -> a + b }
            if (cnt.size > k) {
                if (cnt.merge(cs[l], -1) { a: Int, b: Int -> a+b } == 0) cnt.remove(cs[l])
                l++
            }
        }
        return cs.size - l
    }

}