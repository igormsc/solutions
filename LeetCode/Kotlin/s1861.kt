class Solution1861 {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val (m,n) = box.size to box[0].size
        val res = Array(n) { CharArray(m) }
        (0..<m).forEach { i ->
            var (j, k) = n-1 to n-1
            while (j>=0) {
                res[j][m-i-1] = '.'
                if (box[i][j] != '.') {
                    if (box[i][j] == '*') k = j
                    res[k--][m-i-1] = box[i][j]
                }
                j--
            }
        }
        return res
    }

}
