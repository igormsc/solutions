
class Solution3363 {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {

        val n = fruits.size
        for (i in 0..<n)
            for (j in 0..<n) {
                if (i < j && j < n - 1 - i) fruits[i][j] = 0
                if (j < i && i < n - 1 - j) fruits[i][j] = 0
            }

        val sum = fruits.indices.sumOf { fruits[it][it] }

        for (i in 1..<n)
            for (j in i + 1..<n)
                fruits[i][j] += maxOf(fruits[i - 1][j - 1], fruits[i - 1][j], if (j + 1 < n) fruits[i - 1][j + 1] else 0)

        for (j in 1..<n)
            for (i in j + 1..<n)
                fruits[i][j] += maxOf(fruits[i - 1][j - 1], fruits[i][j - 1], if (i + 1 < n) fruits[i + 1][j - 1] else 0)

        return sum + fruits[n - 1][n - 2] + fruits[n - 2][n - 1]
    }

}