import kotlin.math.absoluteValue

class Solution956 {
    fun tallestBillboard(rods: IntArray): Int {
        val ms = rods.sum()/2
        val m = Array(rods.size) { IntArray(ms+1) {-2} }

        fun dfs(i: Int, s1: Int, s2: Int): Int =
            when {
                (s1>ms) || (s2>ms) -> -1
                i >= rods.size -> if (s1==s2) s1 else -1
                else -> {
                    if (m[i][(s1-s2).absoluteValue] == -2) {
                        val x = maxOf(dfs(i+1, s1, s2), dfs(i+1, s1+rods[i], s2), dfs(i+1, s1,s2+rods[i]))
                        m[i][(s1-s2).absoluteValue] = maxOf(x-maxOf(s1,s2), -1)
                        }
                    m[i][(s1-s2).absoluteValue].let { if (it != -1) it + maxOf(s1,s2) else it}
                }
            }

        return maxOf(dfs(0,0, 0), 0)
    }
}

