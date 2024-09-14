class Solution3223 {
    fun minimumLength(s: String): Int {
        val m = s.fold(mutableMapOf<Int,Int>()){ m, c -> m[c.code] = (m[c.code]?:0) +1; m}
        return s.length - m.values.sumOf{ it - if (it%2 == 0) 2 else 1 }
    }
}