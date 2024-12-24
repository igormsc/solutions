class Solution3291 {
    fun minValidStrings(words: Array<String>, target: String): Int {
        val m = target.length
        val root = TrieNode()
        for (s in words) root.insert(s)
        val dp = IntArray(m + 1) {Int.MAX_VALUE}.also{it[m] = 0}
        for (i in m - 1 downTo 0) root.search(target, i, m - 1, dp)
        return if (dp[0] == Int.MAX_VALUE) -1 else dp[0]
    }

    internal class TrieNode  {
        private val ch = Array<TrieNode?>(26){null}

        fun insert(s: String) {
            var node = this
            for (c in s) {
                val idx = c.code - 'a'.code
                if (node.ch[idx] == null) node.ch[idx] = TrieNode()
                node = node.ch[idx]!!
            }
        }

        fun search(s: String, st: Int, fin: Int, dp: IntArray): Boolean {
            var node = this
            for (i in st..fin) {
                val idx = s[i].code - 'a'.code
                if (node.ch[idx] == null) return false
                node = node.ch[idx]!!
                if (dp[i + 1] != Int.MAX_VALUE) dp[st] = minOf(dp[st], (dp[i + 1] + 1))
            }
            return true
        }
    }

}