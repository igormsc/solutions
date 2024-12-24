class Solution139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val root = TrieNode()
        wordDict.forEach { root.add(it)}
        val dp = BooleanArray(s.length+1).also{it[0]=true}
        s.indices.forEach { i ->
            if (dp[i]) {
                var j = i
                var cur: TrieNode? = root
                while (j<s.length && cur?.ch?.get(s[j].code - 'a'.code) != null) {
                    cur = cur.ch[s[j++].code - 'a'.code]
                    if (cur!!.isWord) dp[j] = true
                }
            }
        }
        return dp[s.length]
    }

    internal class TrieNode() {
        var isWord = false
        var ch = Array<TrieNode?>(26) {null}

        fun add(word: String, ){
            var node = this
            word.forEach { c ->
                if (node.ch[c.code-'a'.code] == null) node.ch[c.code-'a'.code] = TrieNode()
                node = node.ch[c.code-'a'.code]!!
            }
            node.isWord = true
        }
    }

}