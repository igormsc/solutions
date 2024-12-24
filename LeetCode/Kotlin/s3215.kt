class Solution3215 {
    fun tripletCount(a: IntArray, b: IntArray, c: IntArray): Long {
            val cnt1 = LongArray(2)
            val cnt2 = LongArray(2)
            val cnt3 = LongArray(2)
            for (x in a) cnt1[x.countOneBits() and 1]++
            for (x in b) cnt2[x.countOneBits() and 1]++
            for (x in c) cnt3[x.countOneBits() and 1]++
            var res = 0L
            for (i in 0..1)
                for (j in 0..1)
                    for (k in 0..1)
                        if ((i + j + k) % 2 == 0)
                            res += cnt1[i] * cnt2[j] * cnt3[k]
            return res
        }

}