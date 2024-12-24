class Solution3178 {
    fun numberOfChild(n: Int, k: Int): Int {
        val n = n - 1
        val (round, rem) = k / n to k % n
        return if (round % 2 == 0 ) rem else n - rem
    }
}
