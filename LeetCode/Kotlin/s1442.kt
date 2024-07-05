class Solution1442 {
    fun countTriplets(arr: IntArray): Int {
        var res = 0
        var pr = 0
        val cnt = mutableMapOf(0 to 1)
        val total = mutableMapOf<Int,Int>()
        arr.forEachIndexed { i, n ->
            pr = pr.xor(n)
            res += cnt.getOrDefault(pr,0) * i - total.getOrDefault(pr,0)
            cnt[pr] = cnt.getOrDefault(pr,0) + 1
            total[pr] = total.getOrDefault(pr,0) + i + 1
        }
        return res
    }
}
