class Solution1002 {
    fun commonChars(words: Array<String>): List<String> {
        val cnt = IntArray(26) {10_000_000}
        words.forEach { w ->
            val cnt1 = w.fold(IntArray(26)) { r, c -> r[c.code - 'a'.code]++; r}
            cnt.indices.forEach { i -> if (cnt[i] > cnt1[i]) cnt[i] = cnt1[i] }
        }
        return cnt.foldIndexed(mutableListOf<String>()) { i, r, c -> repeat(c) {r.add(('a' + i).toString()) } ; r }
    }
}
