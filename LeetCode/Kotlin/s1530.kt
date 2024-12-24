class Solution1530 {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        var res = 0

        fun dfs(n: TreeNode?, dist: Int):  List<Int> {
            if (n==null) return IntArray(dist+1).toList()
            if (n.left == null && n.right == null) return IntArray(dist+1).also{it[1]++}.toList()
            val l = dfs(n.left, dist)
            val r = dfs(n.right, dist)
            (1..l.lastIndex).forEach { i ->
                (dist-1 downTo 0).forEach { j -> if (i+j <= dist) res +=l[i]*r[j] } }
            return (dist-1 downTo 1).fold(IntArray(dist+1)) { a, i -> a[i+1] = l[i]+r[i]; a}.toList()
        }
        dfs(root, distance)
        return res
    }

}
