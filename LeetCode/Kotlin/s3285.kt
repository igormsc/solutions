class Solution3285 {
    fun stableMountains(height: IntArray, threshold: Int): List<Int> =
        height.withIndex().filter { it.value > threshold }.map{it.index+1}
}
