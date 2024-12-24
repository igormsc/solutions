class Solution632 {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val ordered = nums.foldIndexed(mutableListOf<IntArray>()) { i, r, d -> d.forEach { n -> r.add(intArrayOf(n,i)) }; r}
                          .also { it.sortWith(compareBy({ it[0] }, { it[1] }))}
        var (i, k) = 0 to 0
        var res: IntArray? = null
        val cnt = mutableMapOf<Int,Int>()
        ordered.indices.forEach { j ->
            if ((cnt[ordered[j][1]]?:0) == 0) k++
            cnt[ordered[j][1]] = (cnt[ordered[j][1]]?:0) + 1
            if (k==nums.size) {
                while ((cnt[ordered[i][1]]?:0) > 1) cnt[ordered[i][1]] = (cnt[ordered[i++][1]]?:0) - 1
                if (res == null || res!![1]-res!![0] > ordered[j][0]-ordered[i][0]) res = intArrayOf(ordered[i][0], ordered[j][0])
            }
        }
        return res!!
    }
}
