class Solution311 {
    fun multiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
        val ans = Array(mat1.size) { IntArray(mat2[0].size) }
        val (g1, g2) = f(mat1) to f(mat2)
        for (i in mat1.indices)
            for (p in g1[i]) {
                val (k, x) = p
                for (q in g2[k]) {
                    val (j, y) = q
                    ans[i][j] += x * y
                }
            }
        return ans
    }

    private fun f(m: Array<IntArray>): Array<MutableList<IntArray>> {
        val g = Array(m.size) { mutableListOf<IntArray>() }
        for (i in m.indices)
            for (j in m[0].indices)
                if (m[i][j] != 0) g[i].add(intArrayOf(j, m[i][j]))
        return g
    }

}