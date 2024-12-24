class Solution1554 {
    fun differByOne(dict: Array<String>): Boolean {
        val trie = Trie()
        dict.forEach { trie.insert(it) }

        for (word in dict)
            if (trie.containsDiffByOne(word))
                return true
        return false
    }

    internal class Trie {
        var root: TrieNode = TrieNode()

        fun insert(word: String) {
            var cur: TrieNode = root

            for (i in word.indices) {
                val c = word[i]
                if (!cur.ch.containsKey(c))
                        cur.ch[c] = TrieNode()
                cur = cur.ch[c]!!
                cur.cnt++
            }
            cur.isWord = true
        }

        fun containsDiffByOne(word: String): Boolean {
            var cur: TrieNode = root
            for (i in word.indices) {
                val c = word[i]
                for (key in cur.ch.keys) {
                    if (c != key && contains(cur.ch[key], word, i + 1)) return true
                }
                if (cur.ch[c]!!.cnt <= 1) return false
                cur = cur.ch[c]!!
            }
            return false
        }

        private fun contains(node: TrieNode?, word: String, i: Int): Boolean {
            var nd = node
            for (j in i..word.lastIndex) {
                val c = word[j]
                if (!nd!!.ch.containsKey(c)) return false
                nd = nd.ch[c]
            }
            return nd!!.isWord
        }
    }

    internal class TrieNode {
        var cnt: Int = 0
        var isWord: Boolean = false
        var ch = mutableMapOf<Char, TrieNode?>()
    }
}