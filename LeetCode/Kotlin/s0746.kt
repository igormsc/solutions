class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var (f, s) = cost
        if (cost.size>2) (2..cost.lastIndex).forEach { i -> f = s.also{s=cost[i] + minOf(f, s)} }
        return minOf(f, s)
    }
}
