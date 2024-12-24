class Solution069 {
    fun mySqrt(x: Int): Int {
        var r = x.toLong()
        val x = x.toLong()
        while (r*r>x) r = (r+x/r)/2
        return r.toInt()
    }
}