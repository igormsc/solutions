class Solution3233 {
    val mx = 31622
    val p = BooleanArray(mx+1) {true}.also { it[0] = false; it[1] = false }

    init {
        (2..178).forEach { i -> if (p[i]) (i*i..mx step i).forEach { p[it] = false } }
    }

    fun nonSpecialCount(l: Int, r: Int): Int = (r - l + 1) - (2..mx).count { p[it] && it*it in l..r }
}