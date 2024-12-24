class Solution116 {
    fun connect(root: Node?): Node? {
        var s = root
        while (s != null) {
            var cur = s
            while (cur != null) {
                if (cur.left != null) cur.left!!.next = cur.right
                if (cur.right != null && cur.next != null) cur.right!!.next = cur.next!!.left
                cur = cur.next
            }
            s = s.left
        }
        return root
    }
}
