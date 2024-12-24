class Solution1788 {
    fun maximumBeauty(flowers: IntArray): Int {
        val s = IntArray(flowers.size + 1)
        val mp = mutableMapOf<Int, Int>()
        var res = Int.MIN_VALUE
        for (i in flowers.indices) {
            val v = flowers[i]
            if (mp.containsKey(v)) res = maxOf(res, s[i] - s[mp[v]!! + 1] + v * 2)
            else mp[v] = i
            s[i + 1] = s[i] + maxOf(v,0)
        }
        return res
    }

}