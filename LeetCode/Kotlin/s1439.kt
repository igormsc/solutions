class Solution1439 {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        val (n,m) = mat.size to mat[0].size
        if (n==1) return mat[0][k-1]
        if (m==1 || k==1) {
            return mat[0].sum()
        }
        var (l, r) = 0 to m*5000+1

        fun chk(mid: Int, i: Int, sm: Int): Int {
            if (sm>mid) return 0
            var (x,y) = 0 to 0
            if (i==n) if (sm<=mid) return 1 else return 0
            for (j in 0..<m) {
                if (sm+mat[i][j] > mid) break
                y = chk(mid, i+1, sm+mat[i][j])
                if (y==0) return x
                x +=y
                if (x>k) return x
            }
            return x
        }

        while (l<r) {
            val mid = l+(r-l)/2
            if (chk(mid,0,0) < k) l = mid+1 else r = mid
        }
        return l
    }
}
