class Solution894 {
    fun allPossibleFBT(n: Int): List<TreeNode?> {
        val m = mutableMapOf<Int,MutableList<TreeNode?>>()

        fun fs(n: Int): MutableList<TreeNode?> =
            when {
                m.containsKey(n) -> m[n]!!
                n == 1 -> mutableListOf<TreeNode?>(TreeNode(0)).also{m[n]=it}
                n%2 == 0 -> mutableListOf()
                else -> {
                    val t = mutableListOf<TreeNode?>()
                    (0..<n).forEach { x ->
                        val y = n - x - 1
                        fs(x).forEach { l ->
                            fs(y).forEach { r ->
                                t.add(TreeNode(0).also{it.left=l;it.right=r}) } } }
                    t.also{m[n]=t}
                }
            }
            return fs(n)
        }
}
