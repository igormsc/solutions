class Solution3265 {
    fun countPairs(nums: IntArray): Int {
        val fq = mutableMapOf<Int, Int>()
        var res = 0
        for (n in nums) {
            val f  = fq[n]?:0
            fq[n] = f + 1
            res += f
            val st = String.format("%07d", n)
            for (i in st.indices)
                for (j in i+1..st.lastIndex) {
                    val b = st.toCharArray()
                    b[i] = b[j].also{b[j] = b[i]}
                    val x = String(b).toInt()
                    if (x!=n) res += fq[x]?:0
                }
        }
        return res
    }
}