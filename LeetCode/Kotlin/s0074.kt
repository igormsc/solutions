class Solution074 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        val (m,n) = matrix.size to matrix[0].size
        var (l,r)= 0 to m*n-1
        while (l<=r) {
            val mid = (l+r)/2
            if (target< matrix[mid/n][mid%n]) r = mid-1 else
                if (target > matrix[mid/n][mid%n]) l = mid+1 else return true
        }
        return false
    }
}