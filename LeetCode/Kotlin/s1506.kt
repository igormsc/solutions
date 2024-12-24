class Solution1506 {
    fun findRoot(tree: List<Node>): Node? {
        var x = 0
        tree.forEach { node ->
            x = x.xor(node.`val`)
            node.children.forEach { x = x.xor(it!!.`val`) }
        }
        return tree.find { x == it.`val` }
    }

}