class Solution426 {
    fun treeToDoublyList(root:Node?): Node? {
        if (root == null) return null

        var prev: Node? = null
        var head: Node? = null

        fun dfs(root: Node?) {
            if (root == null) return
            dfs(root.left)
            if (prev != null) {
                prev!!.right = root
                root.left = prev
            } else head = root
            prev = root
            dfs(root.right)
        }

        dfs(root)
        prev?.right = head
        head?.left = prev
        return head
    }

}