class BSTIterator(root: TreeNode?) {

    private val nums = mutableListOf<Int>()
    private var i = -1

    init {
        dfs(root)
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        nums.add(root.`val`)
        dfs(root.right)
    }

    fun hasNext(): Boolean = i < nums.lastIndex

    fun next(): Int = nums[++i]

    fun hasPrev(): Boolean = i > 0

    fun prev(): Int = nums[--i]


}