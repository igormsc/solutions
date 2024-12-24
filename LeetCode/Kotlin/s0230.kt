class Solution230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val st = mutableListOf<TreeNode>()
        var root = root
        while (root != null) {
            st.add(root)
            root = root.left
        }
        var k = k
        while (k != 0) {
            val n = st.removeLast()
            if (--k == 0) return n.`val`
            var r = n.right
            while (r != null) {
                st.add(r)
                r = r.left
            }
        }
        return -1
    }
}
