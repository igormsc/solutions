class Solution360 {
    fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
        var (i, j) = 0 to nums.lastIndex
        var k = if (a < 0) 0 else nums.lastIndex
        val res = IntArray(nums.size)
        fun f(x: Int): Int = a * x * x + b * x + c

        while (i <= j) {
            val (u, v) = f(nums[i]) to f(nums[j])
            if (a < 0) {
                if (u <= v) res[k] = u .also{i++}
                else res[k] = v.also{j--}
                k++
            } else {
                if (u >= v) res[k] = u .also{i++}
                else res[k] = v .also{j--}
                k--
            }
        }
        return res
    }

}