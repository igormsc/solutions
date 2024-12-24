class Solution3209 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var cnt = mutableMapOf<Int, Int>()
        var res = 0L
        nums.forEach {  n ->
            val cnt1= mutableMapOf<Int, Int>()
            if (k.and(n) == k) {
                cnt1[n] = 1
                cnt.forEach { (v, c) -> cnt1[v.and(n)] = (cnt1[v.and(n)]?:0) + c }
                res += (cnt1[k]?:0).toLong()
            }
            cnt = cnt1
        }
        return res
    }
}
