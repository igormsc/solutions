class Solution85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0
        val n = matrix.first().size
        val left = IntArray(n)
        val right = IntArray(n) { n }
        val height = IntArray(n)
        var area = 0
        matrix.indices.forEach { i ->
            var (l, r) = 0 to n
            matrix.first().indices.forEach { j ->
                if (matrix[i][j] == '1') height[j]++.also { left[j] = maxOf(l, left[j]) }
                else {
                    l = j + 1
                    height[j] = 0
                    left[j] = 0
                    right[j] = n
                }
            }
            (n - 1 downTo 0).forEach { j ->
                if (matrix[i][j] == '1') {
                    right[j] = minOf(r, right[j])
                    area = maxOf(area, height[j] * (right[j] - left[j]))
                }
                else r = j
            }
        }
        return area
    }
}
