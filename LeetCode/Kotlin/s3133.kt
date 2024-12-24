class Solution3133 {
    fun minEnd(n: Int, x: Int): Long {
        val x = x.toLong()
        val n = n.toLong()
        var res = x
        var bx = 1L
        var bn = 1L
        while (bn<n) {
            if (bx.and(x)==0L) {
                if (bn.and(n-1)!=0L) res +=bx
                bn = bn.shl(1)
            }
            bx = bx.shl(1)
        }
        return res
    }

}
