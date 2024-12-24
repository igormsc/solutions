class Solution834 {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val tree = Array(n) { mutableListOf<Int>() }
        edges.forEach {
            tree[it[0]].add(it[1])
            tree[it[1]].add(it[0])
        }

        val res = IntArray(n)
        val count = IntArray(n) {1}

        fun dfs(root: Int, pre: Int) {
            tree[root].forEach{
                if (it != pre) {
                    dfs(it, root)
                    count[root] += count[it]
                    res[root] += res[it] + count[it]
                }
            }
        }
        fun dfs2(root: Int, pre: Int) {
            tree[root].forEach{
                if (it != pre) {
                    res[it] = res[root] - count[it] + n - count[it]
                    dfs2(it, root)
                }
            }
        }
        dfs(0, -1)
        dfs2(0, -1)
        return res
    }

}