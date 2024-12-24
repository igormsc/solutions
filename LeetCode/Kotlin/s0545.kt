class Solution545 {
    fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val res = mutableListOf<Int>()
            res.add(root.`val`)
            if (root.left == root.right) return res.toList()

            val left = mutableListOf<Int>()
            val leaves = mutableListOf<Int>()
            val right = mutableListOf<Int>()
            dfs(left, root.left, 0)
            dfs(leaves, root, 1)
            dfs(right, root.right, 2)

            res.addAll(left)
            res.addAll(leaves)
            right.reverse()
            res.addAll(right)
            return res
        }

    private fun dfs(nums: MutableList<Int>, root: TreeNode?, i: Int) {
        if (root == null) return
        if (i == 0) {
            if (root.left != root.right) {
                nums.add(root.`val`)
                if (root.left != null) dfs(nums, root.left, i)
                else dfs(nums, root.right, i)
            }
        } else if (i == 1) {
            if (root.left == root.right) nums.add(root.`val`)
            else {
                dfs(nums, root.left, i)
                dfs(nums, root.right, i)
            }
        } else {
            if (root.left != root.right) {
                nums.add(root.`val`)
                if (root.right != null) dfs(nums, root.right, i)
                else dfs(nums, root.left, i)
            }
        }
    }

}