class Solution742 {

    fun findClosestLeaf(root: TreeNode?, k: Int): Int {
        if (root == null) return 0

        var mnD = Int.MAX_VALUE
        var mnV = root.`val`

        fun traverse(nd: TreeNode?, k: Int, depth: Int): Int {
            var depth = depth
            if (nd == null || depth > mnD || mnD == 0) return -1
            if (nd.left == null && nd.right == null) {
                if (depth in 0..<mnD) {
                    mnD = depth
                    mnV = nd.`val`
                } else if (nd.`val` == k) {
                    mnD = 0
                    mnV = nd.`val`
                }
                return -1
            }
            if (depth >= 0) depth++
            if (nd.`val` == k) depth = 1
            var lD = traverse(nd.left, k, depth)
            val rD = traverse(nd.right, k, if ((lD >= 0)) lD else depth)
            if (rD >= 0) lD = traverse(nd.left, k, rD)
            if (lD >= 0) return lD + 1
            if (rD >= 0) return rD + 1
            return if ((nd.`val` == k)) 1 else -1
        }

        traverse(root, k, -1)
        return mnV
    }

}