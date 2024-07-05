class Solution3085 {
    fun minimumDeletions(word: String, k: Int): Int =
        word.fold(IntArray(26)) { f, c -> f[c.code - 'a'.code]++; f }.let { frq ->
            frq.fold(Int.MAX_VALUE) { res, f ->
                minOf(res, frq.sumOf { if (it < f) it else maxOf(0, (it - f - k)) })
            }
        }

}
