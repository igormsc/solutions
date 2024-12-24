class Solution2764 {
    fun isPreorder(nodes: List<List<Int>>): Boolean {
        val g = mutableMapOf<Int, MutableList<Int>>()
        for (node in nodes)
            g.computeIfAbsent(node[1]) { mutableListOf() }.add(node[0])

        var k = 0
        fun dfs(i: Int): Boolean {
            if (i != nodes[k][0]) return false
            k++
            for (j in g[i]?:listOf())
                if (!dfs(j)) return false

            return true
        }

        return dfs(nodes[0][0]) && k == nodes.size
    }

}