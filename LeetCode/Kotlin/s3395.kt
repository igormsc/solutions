class Solution3395 {
    fun subsequencesWithMiddleMode(nums: IntArray): Int {
        var res = 0L
        val mod = 1_000_000_007L
        fun f(y: Long): Long = y*(y-1)/2
        val (lm, rm) = mutableMapOf<Int,Long>() to mutableMapOf<Int,Long>()
        nums.forEach{ rm[it] = (rm[it]?:0L) + 1L }
        nums.forEachIndexed { i, n ->
            lm.computeIfAbsent(n) { 0L }
            rm[n] = rm[n]!! - 1
            val (cl, cr) = lm[n]!! to rm[n]!!
            val (l, r) = i.toLong() - cl to (nums.lastIndex-i).toLong() - cr
            fun clc(m1: MutableMap<Int,Long>, m2: MutableMap<Int,Long>, b: Long) {
                val s = m1.entries.sumOf { (k, c) -> if (k == n) 0L else f(c) }
                res = m2.entries.fold(0L) { x, (k, c) -> if (k == n) x else (x + (c * m2[n]!! * (f(b - (m1[k] ?: 0L)) - s + f(m1[k] ?: 0L))) % mod) % mod }.let{ (res + it)%mod }
            }
            clc(rm, lm, r)
            clc(lm, rm, l)
            longArrayOf( cl * l * cr * r, cr * r * f(cl), cl * l * f(cr), f(cl) * f(r), f(cr) * f(l), f(cl) * f(cr) ).forEach { res = (res + it%mod)%mod }
            lm[n] = lm[n]!! + 1L
        }
        return res.toInt()
    }
}