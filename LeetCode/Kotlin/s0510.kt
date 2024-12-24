class Solution510 {
    fun inorderSuccessor(node: Node?): Node? {
        var node = node
        if (node!!.right != null) {
            node = node.right
            while (node!!.left != null)
                node = node.left
            return node
        }

        while (node?.parent != null && node.parent?.right === node)
            node = node.parent

        return node?.parent
    }

}

class Node(var `val`: Int) {
		var left: Node? = null
		var right: Node? = null
		var parent: Node? = null
}