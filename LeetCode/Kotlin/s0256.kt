class Solution256 {
    fun minCost(costs: Array<IntArray>): Int {
        var rgb = intArrayOf(0,0,0)
        for (cost in costs) {
            val (r, g, b) = rgb
            rgb = intArrayOf(minOf(g, b) + cost[0], minOf(r, b) + cost[1], minOf(r, g) + cost[2])
        }
        return rgb.min()
    }

}