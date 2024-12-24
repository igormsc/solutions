class Solution3207 {
    fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
        val total = enemyEnergies.sumOf{ it.toLong() } + currentEnergy.toLong()
        val min = enemyEnergies.min().toLong()
        return if (currentEnergy.toLong()<min) 0 else (total-min)/min
    }
}
