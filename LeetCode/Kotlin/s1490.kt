class Solution1490 {
    fun cloneTree(root: Node?): Node? =
        if (root == null) null
        else Node(root.`val`).also{it.children = root.children.fold(mutableListOf()) { r, c -> r.add(cloneTree(c)); r}}

}