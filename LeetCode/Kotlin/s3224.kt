class Solution3224 {
    fun minChanges(nums: IntArray, k: Int): Int {
        val d = IntArray(k+2)
        var (l,r) = 0 to nums.lastIndex
        while (l<r) {
            val (n1,n2) = nums[l++] to nums[r--]
            val (mn, mx) = minOf(n1,n2) to maxOf(n1,n2)
            val x = mx-mn
            d[0]++
            d[x]--
            d[x+1]++
            d[maxOf(mx, k-mn)+1]++
        }
        var cnt = nums.size
        var sum = 0
        d.forEach {
            sum += it
            cnt = minOf(cnt, sum)
        }
        return cnt
    }
}