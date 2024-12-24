class Solution1557 {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val res = mutableListOf<Int>()
        val idg = IntArray(n)
        edges.forEach { (_, v) -> idg[v]++ }
        idg.forEachIndexed { i, v -> if (v==0) res.add(i) }
        return res
    }
}
