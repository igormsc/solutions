class Solution1176 {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        var res = 0
        val n = calories.size
        var s = (0..<k).sumOf { calories[it] }

        fun f() {if (s < lower) res--  else if (s > upper) res++}

        f()
        for (i in k..<n) {
            s += calories[i] - calories[i - k]
            f()
        }

        return res
    }

}
