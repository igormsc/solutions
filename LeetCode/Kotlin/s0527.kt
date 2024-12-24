class Solution527 {
    fun wordsAbbreviation(words: List<String>): List<String> {
        val tries: MutableMap<List<Int>, Trie> = HashMap()
        for (w in words) {
            val key = listOf(w.length, w[w.length - 1].code - 'a'.code)
            tries.putIfAbsent(key, Trie())
            tries[key]!!.insert(w)
        }
        val res = mutableListOf<String>()
        for (w in words) {
            val m = w.length
            val key = listOf(m, w[m - 1].code - 'a'.code)
            val cnt = tries[key]!!.search(w)
            res.add(if (cnt + 2 >= m) w else w.substring(0, cnt) + (m - cnt - 1) + w.substring(m - 1))
        }
        return res
    }

    internal class Trie {
        private val children = arrayOfNulls<Trie>(26)
        private var cnt = 0

        fun insert(w: String) {
            var node: Trie? = this
            for (c in w.toCharArray()) {
                val idx = c.code - 'a'.code
                if (node!!.children[idx] == null) node.children[idx] = Trie()
                node = node.children[idx]
                node!!.cnt++
            }
        }

        fun search(w: String): Int {
            var node: Trie? = this
            var res = 0
            for (c in w.toCharArray()) {
                res++
                node = node!!.children[c.code - 'a'.code]
                if (node!!.cnt == 1) return res
            }
            return w.length
        }
    }



}