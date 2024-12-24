class Solution440 {
    fun findKthNumber(n: Int, k: Int): Int {
        var res = 1L
        var k = (k-1).toLong()
        while (k>0) {
            val g = f(res, res+1, n.toLong())
            if (g<=k) { k -= g; res++}
            else {k--; res *=10}
        }
        return res.toInt()
    }

    private fun f(a: Long, b: Long, n: Long): Long {
        var g = 0L
        var a = a
        var b = b
        while (a<=n) {
            g += minOf(n+1,b)-a
            a *=10
            b *= 10
        }
        return g
    }

}
