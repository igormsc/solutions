class Solution514 {
    fun findRotateSteps(ring: String, key: String): Int {
        val size = ring.length
        val ksize = key.length

        val mp = ring.foldIndexed(Array('z'.code+1) { mutableListOf<Int>() }) { i, m, c -> m[c.code].add(i); m }
        var dp = IntArray(size) { Int.MAX_VALUE }.also { it[0] = 0 }
        var startIndex = mutableListOf(0)
        (1..ksize).forEach { i ->
            val nextOp = IntArray(size) { Int.MAX_VALUE }
            mp[key[i - 1].code].forEach { k ->
                startIndex.forEach { s ->
                    nextOp[k] = minOf(minOf((s + size - k) % size, (k + size - s) % size) + dp[s], nextOp[k])
                }
            }
            startIndex = mp[key[i - 1].code]
            dp = nextOp
        }
        return dp.min() + ksize
    }
}