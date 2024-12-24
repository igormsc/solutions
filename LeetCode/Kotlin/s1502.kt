class Solution1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val n = arr.size
        val (min, max) = arr.min() to arr.max()
        if ((max-min)%(n-1) != 0) return false
        val step = (max-min)/(n-1)
        if (step == 0) return true
        val set = mutableSetOf<Int>()
        for (a in arr) {
            if ((a-min)%step != 0) return false
            if (set.contains(a)) return false else set.add(a)
        }
        return true
    }
}
