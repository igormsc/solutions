class Solution425 {
    fun wordSquares(words: Array<String>): List<List<String>> {
        val trie = Trie()
        val ans = mutableListOf<List<String>>()

        words.forEachIndexed{ i, w -> trie.insert(w, i) }

        fun dfs(t: MutableList<String>) {
            if (t.size == words[0].length) {
                ans.add(ArrayList(t))
                return
            }
            val idx = t.size
            val pref = StringBuilder()
            for (x in t) pref.append(x[idx])
            val indexes = trie.search(pref.toString())
            for (i in indexes) {
                t.add(words[i])
                dfs(t)
                t.removeLast()
            }
        }

        val t = mutableListOf<String>()
        for (w in words) {
            t.add(w)
            dfs(t)
            t.removeLast()
        }
        return ans
    }

    internal class Trie {
        private var children: Array<Trie?> = arrayOfNulls(26)
        private var v = mutableListOf<Int>()

        fun insert(word: String, i: Int) {
            var node: Trie? = this
            for (c in word.toCharArray()) {
                val c = c.code - 'a'.code
                if (node!!.children[c] == null) node.children[c] = Trie()
                node = node.children[c]
                node!!.v.add(i)
            }
        }

        fun search(pref: String): List<Int> {
            var node: Trie? = this
            for (c in pref.toCharArray()) {
                val c = c.code - 'a'.code
                if (node!!.children[c] == null) return listOf()
                node = node.children[c]
            }
            return node!!.v
        }
    }


}

