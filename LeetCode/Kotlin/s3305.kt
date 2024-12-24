class Solution3305 {
    fun countOfSubstrings(word: String, k: Int): Int {
            var count = 0
            word.indices.forEach { i ->
                var str = ""
                (i..<word.length).forEach { j ->
                    str += word[j]
                    if (str.length >= 5 && "aeiou".all{str.contains(it)} && isCons(str, k)) count++
                }
            }
            return count
    }

    private fun isCons(str: String, k: Int): Boolean {
        var cnt = 0
        str.forEach{if (it !in "aeiou" && ++cnt > k) return false}
        return k <= cnt
    }
}

