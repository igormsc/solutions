class Solution1894 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var k = k.toLong() % chalk.sumOf {it.toLong()}
        chalk.forEachIndexed { i, c ->
            k -= c.toLong()
            if (k<0L) return i
        }
        return 0
    }
}