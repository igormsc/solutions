class Solution2107 {
    fun shareCandies(candies: IntArray, k: Int): Int {
        val cnt = candies.fold(mutableMapOf<Int, Int>()) { r, c -> r[c] = (r[c]?:0) + 1; r}
        var res = 0
        candies.indices.forEach { i ->
            val x = candies[i]
            cnt[x] = cnt[x]!! - 1
            if (cnt[x] == 0) cnt.remove(x)
            if (i >= k) cnt[candies[i - k]] = (cnt[candies[i - k]]?:0) + 1
            if (i >= k - 1) res = maxOf(res, cnt.size)
        }
        return res
    }
}
