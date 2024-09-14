class Solution3259 {
    fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long =
        energyDrinkA.indices.fold(0L to 0L) { (a, b), i ->
            maxOf(a + energyDrinkA[i], b) to maxOf(b + energyDrinkB[i], a)
        }.let { maxOf(it.first, it.second) }

}