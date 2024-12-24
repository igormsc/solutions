class Solution1100 {
    fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
        val n = s.length
        if (n < k) return 0
        val cnt = mutableMapOf<Char, Int>()
        for (i in 0..<k)
            cnt.merge(s[i], 1) { a: Int, b: Int -> a+b }

        var res = if (cnt.size == k) 1 else 0
        for (i in k..<n) {
            cnt.merge(s[i], 1) { a: Int, b: Int -> a+b }
            if (cnt.merge(s[i - k], -1) { a: Int, b: Int -> a+b } == 0) cnt.remove(s[i - k])
            res += if (cnt.size == k) 1 else 0
        }
        return res
    }

}