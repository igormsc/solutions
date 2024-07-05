class Solution1382 {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val srt = mutableListOf<TreeNode?>()

        fun inorder(n: TreeNode?): TreeNode? = if (n == null) null else {
            inorder(n.left)
            srt.add(n)
            inorder(n.right)
        }

        fun arrToBST(start: Int, end: Int): TreeNode? = if (start>end) null else {
            val mid = (start+end)/2
            val n = srt[mid]
            n!!.left = arrToBST(start, mid -1)
            n.right = arrToBST(mid+1, end)
            n
        }

        inorder(root)
        return arrToBST(0, srt.lastIndex)
    }

}
