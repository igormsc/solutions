class Solution666 {
    fun pathSum(nums: IntArray): Int {
        var res = 0
        val mp = mutableMapOf<Int, Int>()
        for (num in nums) mp[num / 10] = num % 10

        fun dfs(node: Int, t: Int) {
            var t = t
            if (!mp.containsKey(node)) return

            t += mp[node]!!
            val d = node / 10
            val p = node % 10
            val l = (d + 1) * 10 + (p * 2) - 1
            val r = l + 1
            if (!mp.containsKey(l) && !mp.containsKey(r)) {
                res += t
                return
            }
            dfs(l, t)
            dfs(r, t)
        }

        dfs(11, 0)
        return res
    }

}