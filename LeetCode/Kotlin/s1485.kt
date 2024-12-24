class Solution1485 {
    fun copyRandomBinaryTree(root: Node?): NodeCopy? {
            val mp = mutableMapOf<Node, NodeCopy>()

            fun dfs(root: Node?): NodeCopy? {
                if (root == null) return null
                if (mp.containsKey(root)) return mp[root]

                val copy = NodeCopy(root.`val`)
                mp[root] = copy
                copy.left = dfs(root.left)
                copy.right = dfs(root.right)
                copy.random = dfs(root.random)
                return copy
            }

            return dfs(root)
        }

}