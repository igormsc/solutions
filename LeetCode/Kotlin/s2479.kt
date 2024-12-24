class Solution2479 {
    fun maxXor(n: Int, edges: Array<IntArray>, values: IntArray): Long {
        val g = Array(n){ mutableListOf<Int>() }
        val s = LongArray(n)
        var tr: Trie? = null
        var res = 0L

        for (e in edges) {
            val (u,v) = e
            g[u].add(v)
            g[v].add(u)
        }

        fun dfs1(i: Int, fa: Int): Long {
            var t = values[i].toLong()
            for (j in g[i])
                if (j != fa) t += dfs1(j, i)
            s[i] = t
            return t
        }
        dfs1(0, -1)
        tr = Trie()

        fun dfs2(i: Int, fa: Int) {
            res = maxOf(res, tr.search(s[i]))
            for (j in g[i])
                if (j != fa) dfs2(j, i)
            tr.insert(s[i])
        }
        dfs2(0, -1)
        return res
    }


    internal class Trie {
        var children = Array<Trie?>(2) {null}

        fun insert(x: Long) {
            var node = this
            for (i in 47 downTo 0) {
                val v = (x shr i).toInt() and 1
                if (node.children[v] == null) node.children[v] = Trie()
                node = node.children[v]!!
            }
        }

        fun search(x: Long): Long {
            var node: Trie? = this
            var res: Long = 0
            for (i in 47 downTo 0) {
                val v = (x shr i).toInt() and 1
                if (node == null) return res
                if (node.children[v xor 1] != null) {
                    res = res shl 1 or 1L
                    node = node.children[v xor 1]
                } else {
                    res = res shl 1
                    node = node.children[v]
                }
            }
            return res
        }
    }

}