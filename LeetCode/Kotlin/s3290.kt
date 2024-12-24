class Solution3290 {
    fun maxScore(a: IntArray, b: IntArray): Long =
        b.fold(LongArray(4){-40000000000L}) { r, n ->
            val n = n.toLong()
            longArrayOf( maxOf(r[0], n*a[0]), maxOf(r[1],r[0]+n*a[1]), maxOf(r[2], r[1] + n*a[2]),  maxOf(r[3], r[2]+n*a[3]))
        }[3]
}
