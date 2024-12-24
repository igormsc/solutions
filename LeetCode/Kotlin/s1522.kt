class Solution1522 {
    fun diameter(root: Node?): Int {
        var res = 0
        var next: Node? = root
        val vis = mutableSetOf<Node?>()
        val g = mutableMapOf<Node?, MutableSet<Node?>>()

        fun build(root: Node?) {
            if (root == null) return
            root.children.forEach { child ->
                g.computeIfAbsent(root) { mutableSetOf() }.add(child)
                g.computeIfAbsent(child) { mutableSetOf() }.add(root)
                build(child)
            }
        }
        build(root)

        fun dfs(u: Node?, t: Int) {
            if (vis.contains(u)) return
            vis.add(u)
            if (t > res) {
                res = t
                next = u
            }
            if (g.containsKey(u))
                for (v in g[u]!!) dfs(v, t + 1)
        }
        dfs(next, 0)
        vis.clear()
        dfs(next, 0)

        return res
    }

}