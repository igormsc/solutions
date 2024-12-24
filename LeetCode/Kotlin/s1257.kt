class Solution1257 {
    fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
        var (r1, r2) = region1 to region2
        val m = mutableMapOf<String?, String>()
        for (region in regions)
            for (i in 1..region.lastIndex)
                m[region[i]] = region[0]
        val s = mutableSetOf<String?>()
        while (m.containsKey(r1)) {
            s.add(r1)
            r1 = m[r1]!!
        }
        while (m.containsKey(r2)) {
            if (s.contains(r2)) return r2
            r2 = m[r2]!!
        }
        return r1
    }

}