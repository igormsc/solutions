class Solution117 {
    fun connect(root: Node?): Node? {
        var root = root
        var d = Node(0)
        var start = root
        while (root != null) {
            var cur: Node? = d
            d.next = null
            while (root != null) {
                if (root.left != null) {
                    cur?.next = root?.left
                    cur = cur?.next
                }
                if (root.right != null) {
                    cur?.next = root.right
                    cur = cur?.next
                }
                root = root.next
            }
            root = d.next
        }
        return start
    }
}
