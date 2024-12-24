class Solution3147 {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        (energy.lastIndex - k  downTo 0).forEach { i -> energy[i] += energy[i + k] }
        return energy.max()
    }
}
