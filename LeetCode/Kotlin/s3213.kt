class Solution3213 {
    fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {
        val root = Trie()
        words.indices.forEach { i -> insert(words[i], costs[i], root) }

        val n = target.length
        val dp = IntArray(n+5){1_000_000_000}.also{it[0] = 0}
        for (i in target.indices){
            if (dp[i] == 1_000_000_000) continue
            var curr = root
            for (j in i..<n) {
                val t = target[j].code - 'a'.code
                if (curr.ch[t] == null) break
                curr = curr.ch[t]!!
                if (curr.cost == 1_000_000_000) continue
                dp[j+1] = minOf(dp[j+1], dp[i]+curr.cost)
            }
        }
        return if (dp[n] == 1_000_000_000) -1 else dp[n]

    }

    internal class Trie {
        val ch = Array<Trie?>(26) {null}
        var cost = 1_000_000_000
    }

    private fun insert(key: String, c: Int, root: Trie) {
        var node = root
        key.forEach { k ->
            val k = k.code - 'a'.code
            if (node.ch[k] == null) node.ch[k] =  Trie()
            node = node.ch[k]!!
        }
        node.cost = minOf(node.cost, c)
    }

}

fun main() {
    val sl = Solution3213()

    val target = "abcdef"
    val words = arrayOf("abdef","abc","d","def","ef")
    val costs = intArrayOf(100,1,1,10,5)

    println(sl.minimumCost(target, words, costs))
}

