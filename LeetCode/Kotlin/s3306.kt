class Solution3306 {

    fun countOfSubstrings(word: String, k: Int): Long {
        val aeiou = "aeiou".withIndex()

        fun cntK(k: Int): Long {
            var res = 0L
            var j = 0
            val c = IntArray(6)
            var uniq = 0
            word.indices.forEach { i ->
                var p = (aeiou.find { it.value == word[i] }?.index ?: -1) + 1
                uniq += if (++c[p] == 1 && p != 0) 1 else 0
                while (uniq == 5 && c[0] >= k) {
                    res += (word.length - i).toLong()
                    p = (aeiou.find { it.value == word[j] }?.index ?: -1) + 1
                    j++
                    uniq -= if (--c[p] == 0 && p != 0) 1 else 0
                }
            }
            return res
        }

        return cntK(k) - cntK(k + 1)
    }

}
