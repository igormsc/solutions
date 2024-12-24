class Solution476 {
    fun findComplement(num: Int): Int {
        var m = -1
        while (num.and(m) != 0) m = m.shl(1)
        return -(m+1) and -(num+1)
    }
}