class MyCalendar() {

    private var root: TreeNode? = null

    fun book(start: Int, end: Int): Boolean {
        if (root == null) {
            root = TreeNode(start, end)
            return true
        }
        return insert(root!!, start, end)
    }

    private fun insert(r: TreeNode, start: Int, end: Int): Boolean {
        if (end <= r.start) {
            if (r.left == null) {
                r.left = TreeNode(start, end)
                return true
            }
            return insert(r.left!!, start, end)
        }
        if (start >= r.end) {
            if (r.right == null) {
                r.right = TreeNode(start, end)
                return true
            }
            return insert(r.right!!, start, end)
        }
        return false
    }

    private class TreeNode(var start: Int, var end: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
