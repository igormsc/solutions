class Solution2237 {
    fun meetRequirement(n: Int, lights: Array<IntArray>, requirement: IntArray): Int {
        val cnt = IntArray(100_001)
        lights.forEach { l ->
                            cnt[maxOf(0, l[0] - l[1])]++
                            cnt[minOf(n - 1, l[0] + l[1]) + 1]-- }
        var s = 0
        return (0..<n).count {
                                    s += cnt[it]
                                    s >= requirement[it] }
    }

}