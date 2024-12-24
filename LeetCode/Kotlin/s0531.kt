class Solution531 {
    fun findLonelyPixel(picture: Array<CharArray>): Int {
        val (m, n) = picture.size to picture[0].size
        val (rows, cols) = IntArray(m) to IntArray(n)
        for (i in rows.indices)
            for (j in cols.indices)
                if (picture[i][j] == 'B') { rows[i]++; cols[j]++ }
        return rows.indices.sumOf{ i ->
                cols.indices.count { j -> picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1 } }
    }

}