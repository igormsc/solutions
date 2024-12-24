class Solution2128 {
    fun removeOnes(grid: Array<IntArray>): Boolean {
        val s = mutableSetOf<String>()
        for (row in grid)
            s.add(row.indices.fold(CharArray(row.size)) { r, i -> r[i] = (row[0] xor row[i]).toChar(); r}.joinToString(""))
        return s.size == 1
    }

}