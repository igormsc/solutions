class Solution2028 {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val m = rolls.size
        val mSum = rolls.sum()
        var nSum = mean*(n+m) - mSum
        if (6*n <nSum || n > nSum) return intArrayOf()
        val res = mutableListOf<Int>()
        var n = n
        while (n > 0) {
            val x = if (nSum == n) 1 else minOf(nSum-n+1, 6)
            res.add(x)
            nSum -= x
            n--
        }
        return res.toIntArray()
    }
}