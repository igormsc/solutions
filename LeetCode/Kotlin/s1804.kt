class Trie() {
    val children = Array<Trie?>(26) { null }
    private var v = 0
    private var pv = 0

    fun insert(word: String) {
        var node: Trie? = this
        for (c in word.toCharArray()) {
            val c = c.code - 'a'.code
            if (node!!.children[c] == null) node.children[c] = Trie()
            node = node.children[c]
            node!!.pv++
        }
        node!!.v++
    }

    fun countWordsEqualTo(word: String): Int {
        val node = search(word)
        return node?.v ?: 0
    }

    fun countWordsStartingWith(prefix: String): Int {
        val node = search(prefix)
        return node?.pv ?: 0
    }

    fun erase(word: String) {
        var node: Trie? = this
        for (c in word.toCharArray()) {
            node = node!!.children[c.code - 'a'.code]
            node!!.pv--
        }
        node!!.v--
    }

    fun search(word: String): Trie? {
        var node: Trie? = this
        for (c in word.toCharArray()) {
            val c = c.code - 'a'.code
            if (node!!.children[c] == null) return null
            node = node.children[c]
        }
        return node
    }
}
