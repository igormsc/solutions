class Solution1498 {
    fun numSubseq(nums: IntArray, target: Int): Int {
        val mod = 1_000_000_007
        nums.sort()
        var res = 0
        val n = nums.size
        var (l,r) = 0 to nums.lastIndex
        val pw = IntArray(n).also{it[0]=1}
        (1..pw.lastIndex).forEach { pw[it] = (2*pw[it-1])%mod}
        while (l<=r)
            if (nums[l]+nums[r]>target) r-- else res = (res+pw[r-l++])%mod
        return res
    }
}
