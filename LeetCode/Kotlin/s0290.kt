class Solution0290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (words.size != pattern.length) return false
        val ind = mutableMapOf<String, Int>()
        words.forEachIndexed { i, w ->
            val pt = "_${pattern[i]}"
            val v = ind[pt] ?: -1
            val v1 = ind[w] ?: -2
            if (v != v1) return false
            ind[pt] = i + 1
            ind[w] = i + 1
        }
        return true
    }

}
