class Solution1273 {
    fun deleteTreeNodes(nodes: Int, parent: IntArray, value: IntArray): Int {
        val g = Array(nodes) {mutableListOf<Int>()}
        for (i in 1..<nodes) g[parent[i]].add(i)

        fun dfs(i: Int): IntArray {
            val res = intArrayOf(value[i], 1)
            for (j in g[i]) {
                val t = dfs(j)
                res[0] += t[0]
                res[1] += t[1]
            }
            if (res[0] == 0) res[1] = 0
            return res
        }

        return dfs(0)[1]
    }

}