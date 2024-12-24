class Solution1940 {
    fun longestCommonSubsequence(arrays: Array<IntArray>): List<Int> {
            val cnt = mutableMapOf<Int, Int>()
            for (array in arrays)
                for (e in array)
                    cnt[e] = (cnt[e] ?: 0) + 1
            val n = arrays.size
            return cnt.filterValues { it == n }.map { it.key }
        }
}

