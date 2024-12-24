class Solution1065 {
    fun indexPairs(text: String, words: Array<String>): Array<IntArray> {
        val trie = Trie()
        words.forEach{ trie.insert(it) }

        val n = text.length
        val res = mutableListOf<IntArray>()
        for (i in 0..<n) {
            var node: Trie? = trie
            for (j in i..<n) {
                val idx = text[j].code - 'a'.code
                if (node!!.children[idx] == null) break
                node = node.children[idx]
                if (node!!.isEnd) res.add(intArrayOf(i, j))
            }
        }
        return res.toTypedArray()
    }

    internal class Trie {
        var children = Array<Trie?>(26) {null}
        var isEnd = false

        fun insert(word: String) {
            var node: Trie? = this
            for (c in word.toCharArray()) {
                val c = c.code - 'a'.code
                if (node!!.children[c] == null) node.children[c] = Trie()
                node = node.children[c]
            }
            node!!.isEnd = true
        }
    }

}