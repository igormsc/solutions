class Solution2445 {
    fun numberOfNodes(n: Int, queries: IntArray): Int {
        val tree = IntArray(n + 1)
        val cnt = IntArray(n + 1)
        for (v in queries) cnt[v]++

        fun dfs(i: Int) {
            if (i >= tree.size) return
            tree[i] = tree[i] xor 1
            dfs(i shl 1)
            dfs(i shl 1 or 1)
        }

        for (i in 0..<n + 1)
            if (cnt[i] % 2 == 1) dfs(i)

        return (0..<n + 1).sumOf{tree[it]}
    }

}