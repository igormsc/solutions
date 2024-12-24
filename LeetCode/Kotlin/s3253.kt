class Solution3253 {

    fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {
        val trie = Trie()
        for (i in words.indices)
            trie.insert(words[i], costs[i])

        val target = target.toCharArray()
        val dp = Array<Int?>(target.size) {null}

        fun dfs(i: Int): Int {
            if (i >= target.size) return 0
            if (dp[i] != null) return dp[i]!!

            dp[i] = trie.inf
            var node = trie
            for (j in i..target.lastIndex) {
                val idx = target[j].code - 'a'.code
                if (node.children[idx] == null) return dp[i]!!
                node = node.children[idx]!!
                dp[i] = minOf(dp[i]!!, node.cost + dfs(j + 1))
            }
            return dp[i]!!
        }

        return dfs(0).let {if (it < trie.inf) it else -1}
    }

    internal class Trie {
        val inf: Int = Int.MAX_VALUE/2
        var children = Array<Trie?>(26) {null}
        var cost: Int = inf

        fun insert(word: String, cost: Int) {
            var node = this
            for (c in word.toCharArray()) {
                val idx = c.code - 'a'.code
                if (node.children[idx] == null) node.children[idx] = Trie()
                node = node.children[idx]!!
            }
            node.cost = minOf(node.cost, cost)
        }
    }

}