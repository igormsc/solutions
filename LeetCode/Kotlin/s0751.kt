class Solution751 {
    fun ipToCIDR(ip: String, n: Int): List<String> {
        var n = n
        val res = mutableListOf<String>()

        var ipv = it2l(ip)
        while (n > 0) {
            val mx = mxSize(ipv, n)
            res.add(l2ip(ipv) + "/" + (33 - mx))
            val numValuesRepresented = 1 shl (mx - 1)
            ipv += numValuesRepresented.toLong()
            n -= numValuesRepresented
        }
        return res
    }

    private fun it2l(ip: String): Long {
        var res = 0L
        val x = ip.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (y in x)
            res = res * 256 + y.toInt()
        return res
    }

    private fun l2ip(num: Long): String = String.format("%s.%s.%s.%s",(num shr 24) and 255L,(num shr 16) and 255L,(num shr 8) and 255L, num and 255L)

    private fun mxSize(start: Long, n: Int): Int {
        var i = 1
        while (i < 32 && (start and (1 shl (i - 1)).toLong()) == 0L && ((1 shl i) <= n)) i++
        return i
    }

}