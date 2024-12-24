import kotlin.math.absoluteValue

class Solution2463 {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val dp = Array(101){LongArray(101)}
        val robot = robot.toIntArray()
        robot.sort()
        factory.sortWith { a: IntArray, b: IntArray -> if (a[1] == b[1]) b[0] - a[0] else b[1] - a[1] }

        fun dfs(i: Int, j: Int): Long =
            when {
                j >= robot.size -> 0
                i >= factory.size -> Long.MAX_VALUE/4
                else -> {
                    if (dp[i][j] == 0L) {
                        dp[i][j] = dfs(i+1,j) + 1
                        var q = 0
                        var dist = 0L
                        while (j+q<robot.size && q < factory[i][1]) {
                            dist += (factory[i][0]-robot[j+q]).absoluteValue.toLong()
                            dp[i][j] = minOf(dp[i][j], dfs(i+1, j+q+1) + dist + 1)
                            q++
                        }
                    }
                    dp[i][j]-1
                }
            }

        return dfs(0, 0)
    }
}
