class Solution1305 {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val q1 = mutableListOf<Int>()
        val q2 = mutableListOf<Int>()
        inorder(root1, q1)
        inorder(root2, q2)
        val res = mutableListOf<Int>()
        while (q1.isNotEmpty() || q2.isNotEmpty()) {
            if (q2.isEmpty()) res.add(q1.removeFirst())
            else if (q1.isEmpty()) res.add(q2.removeFirst())
            else {
                if (q1[0]<q2[0]) res.add(q1.removeFirst())
                else res.add(q2.removeFirst())
            }
        }
        return res
    }

    private fun inorder(n: TreeNode?, q: MutableList<Int>) {
        if (n == null) return
        inorder(n.left, q)
        q.add(n.`val`)
        inorder(n.right, q)
    }

}
