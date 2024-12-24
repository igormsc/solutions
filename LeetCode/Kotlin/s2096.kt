class Solution2096 {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val sp = mutableListOf<Char>()
        val dp = mutableListOf<Char>()

        fun find(n: TreeNode?, v: Int, p: MutableList<Char>): Boolean =
            when {
                (n?.`val` == v) -> true
                (n?.left != null && find(n.left, v, p)) -> p.add('L')
                (n?.right != null && find(n.right, v, p)) -> p.add('R')
                else -> p.isNotEmpty()
            }

        find(root, startValue, sp)
        find(root, destValue, dp)

        while (sp.isNotEmpty() && dp.isNotEmpty() && sp.last() == dp.last()) sp.removeLast().also{ dp.removeLast() }

        val res = mutableListOf<Char>()
        repeat(sp.size) { res.add('U') }
        dp.reverse()
        res.addAll(dp)
        return res.joinToString("")
    }

}
