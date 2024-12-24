class Solution3152 {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val ps = nums.drop(1).scanIndexed(0){i, r, n -> r + if (n%2 == nums[i]%2) 1 else 0 }
        return queries.map { ps[it[0]] == ps[it[1]] }.toBooleanArray()
    }
}
