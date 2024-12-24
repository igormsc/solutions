class Solution3119 {
    fun maxPotholes(road: String, budget: Int): Int {
        val road = "$road."
        var budget = budget
        val n = road.length
        val cnt = IntArray(n)
        var k = 0
        for (c in road.toCharArray())
            if (c == 'x') k++ else if (k > 0) cnt[k]++.also{ k = 0 }
        var res = 0
        k = n - 1
        while (k > 0 && budget > 0) {
            val t = minOf(budget / (k + 1), cnt[k])
            res += t * k
            budget -= t * (k + 1)
            cnt[k - 1] += cnt[k--] - t
        }
        return res
    }

}