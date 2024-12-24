class Codec431 {
    fun encode(root: Node?): TreeNode? {
        if (root == null) return null

        val res = TreeNode(root.`val`)
        if (root.children.isNotEmpty())
            res.left = encode(root.children[0])

        var cur = res.left
        for (i in 1..root.children.lastIndex) {
            cur!!.right = encode(root.children[i])
            cur = cur.right
        }
        return res
    }

    fun decode(root: TreeNode?): Node? {
        if (root == null) return null
        val res = Node(root.`val`)
        var cur = root.left
        val ch = mutableListOf<Node?>()
        while (cur != null) {
            ch.add(decode(cur))
            cur = cur.right
        }
        res.children = ch.toList()
        return res
    }
}
