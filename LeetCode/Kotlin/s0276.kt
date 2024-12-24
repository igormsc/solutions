class Solution276 {
    fun numWays(n: Int, k: Int): Int {
        var (f, g) = k to 0
        for (i in 1..<n) g = f.also{ f = (f + g) * (k - 1)}
        return f + g
    }

}