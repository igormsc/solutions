class Solution1652 {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val n = code.size
        val res = IntArray(n)
        if (k==0) return res
        var (s,e) = if (k<0) (n + k) to (n - 1) else 1 to k
        var sum = (s..e).sumOf { code[it] }
        code.indices.forEach { i ->
            res[i] = sum
            sum = sum - code[s++%n] + code[(++e)%n]
        }
        return res
    }
}
