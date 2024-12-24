class Solution1072 {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val m = mutableMapOf<String, Int>()
        return matrix.indices.maxOf { i ->
            val (s1, s2) = mutableListOf<Char>() to mutableListOf<Char>()
            matrix[i].indices.maxOf { j ->
                if (matrix[i][j] == 1) {
                    s1.add('a')
                    s2.add('b')
                } else {
                    s1.add('b')
                    s2.add('a')
                }
            }
            val (a1, a2) = s1.joinToString("") to s2.joinToString("")
            m[a1] = (m[a1] ?: 0) + 1
            m[a2] = (m[a2] ?: 0) + 1
            maxOf(m[a1]!!, m[a2]!!)
        }
    }
}
