class Solution3093 {
    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val t = Trie()
        wordsContainer.forEachIndexed{i, w -> t.insert(w, i, w.lastIndex) }
        return wordsQuery.fold(mutableListOf<Int>()) { r, q -> r.add(t.find(q, q.lastIndex)); r  }.toIntArray()
    }

    private class Trie {
        val ch = arrayOfNulls<Trie>(26)
        var min = Int.MAX_VALUE
        var r = 0

        fun insert (w: String, i: Int, j: Int) {
            if (min > w.length) {
                r = i
                min = w.length
            }
            if (j < 0) return
            val c = w[j].code - 'a'.code
            if (ch[c] == null) ch[c] = Trie()
            ch[c]!!.insert(w, i, j-1)
        }
        fun find(q: String, j: Int): Int = if (j >= 0 && ch[q[j].code - 'a'.code] != null) ch[q[j].code - 'a'.code]!!.find(q, j-1) else r
    }


}
