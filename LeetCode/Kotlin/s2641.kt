class Solution2641 {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val lSum = mutableListOf<Int>()

        fun levelSum(n: TreeNode?, d:Int){
            if (n==null) return
            if (d+1 > lSum.size) repeat(d+1-lSum.size) { lSum.add(0) }
            lSum[d] += n.`val`
            levelSum(n.left,d+1)
            levelSum(n.right,d+1)
        }

        fun updateSum(n: TreeNode?, sSum: Int, d:Int){
            if (n==null) return
            n.`val` = lSum[d] - sSum
            val sum = (if (n.left != null) n.left!!.`val` else 0) + (if (n.right != null) n.right!!.`val` else 0)
            updateSum(n.left, sum,d+1)
            updateSum(n.right, sum,d+1)
        }

        levelSum(root, 0)
        updateSum(root, root?.`val`?:0, 0)
        return root
    }

}
