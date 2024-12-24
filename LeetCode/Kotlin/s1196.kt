class Solution1196 {
    fun maxNumberOfApples(weight: IntArray): Int {
        weight.sort()
        var s = 0
        for (i in weight.indices) {
            s += weight[i]
            if (s > 5000) return i
        }
        return weight.size
    }

}