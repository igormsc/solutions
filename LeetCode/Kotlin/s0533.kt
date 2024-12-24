class Solution533 {
    fun findBlackPixel(picture: Array<CharArray>, target: Int): Int {
        val (m, n) = picture.size to picture[0].size
        val g = Array(n) { mutableListOf<Int>() }
        val rows = IntArray(m)
        for (i in 0..<m)
            for (j in 0..<n)
                if (picture[i][j] == 'B') {
                    rows[i]++
                    g[j].add(i)
                }
        return (0..<n).sumOf { j ->
            if (g[j].isEmpty() || (rows[g[j][0]] != target)) 0
            else {
                val y = g[j][0]
                var s = 0
                if (g[j].size == rows[y]) {
                    s = target
                    for (i2 in g[j])
                        if (!picture[y].contentEquals(picture[i2])) {
                            s = 0
                            break
                        }
                }
                s
            }
        }
    }

}