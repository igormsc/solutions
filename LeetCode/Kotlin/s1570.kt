class SparseVector(nums: IntArray) {
    var m = mutableMapOf<Int, Int>()
    init {
        for (i in nums.indices)
            if (nums[i] != 0) m[i] = nums[i]
    }

    fun dotProduct(vec: SparseVector): Int {
        var (a, b) = m to vec.m
        if (b.size < a.size)
            a = b .also { b = a }
        var res = 0
        for ((k, v) in a)
            res += v * (b[k]?:0)
        return res
    }

}