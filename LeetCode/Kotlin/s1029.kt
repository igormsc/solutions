
import java.util.*

internal class Solution1029 {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        Arrays.sort(costs) { a: IntArray, b: IntArray -> a[0] - a[1] - b[0] + b[1] }
        val n = costs.size / 2
        return (0..<n).sumOf { costs[it][0] + costs[it + n][1] }
    }
}