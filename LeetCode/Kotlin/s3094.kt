class Solution3094 : Problem() {
    fun findNumber(): Int =
        (0..29).fold(0) { r, i -> if (commonBits(1.shl(i)) > commonBits(1.shl(i))) r.or(1.shl(i)) else r }
}
