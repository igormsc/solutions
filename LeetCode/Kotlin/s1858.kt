class Solution1858 {
    fun longestWord(words: Array<String>): String {
        val trie = Trie()
        words.forEach { trie.insert(it) }
        var res = ""
        for (w in words)
            if ((w.length > res.length || (w.length == res.length && w < res)) && trie.search(w)) res = w
        return res
    }

    internal class Trie {
        private val children = Array<Trie?>(26) {null}
        private var isEnd = false

        fun insert(w: String) {
            var node = this
            for (c in w.toCharArray()) {
                val idx = c.code - 'a'.code
                if (node.children[idx] == null) node.children[idx] = Trie()
                node = node.children[idx]!!
            }
            node.isEnd = true
        }

        fun search(w: String): Boolean {
            var node = this
            for (c in w.toCharArray()) {
                node = node.children[c.code - 'a'.code]!!
                if (!node.isEnd) return false
            }
            return true
        }
    }

}