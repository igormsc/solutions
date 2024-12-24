class Solution1152 {
    fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        val d = mutableMapOf<String, MutableList<Node>>()
        val n = username.size
        for (i in 0..<n) {
            val user = username[i]
            val ts = timestamp[i]
            val site = website[i]
            d.computeIfAbsent(user) { mutableListOf() }.add(Node(user, ts, site))
        }
        val cnt = mutableMapOf<String, Int>()
        for (sites in d.values) {
            val m = sites.size
            val s = mutableSetOf<String>()
            if (m > 2) {
                sites.sortBy { it.ts }
                for (i in 0..<m - 2)
                    for (j in i + 1..<m - 1)
                        for (k in j + 1..<m)
                            s.add(sites[i].site + "," + sites[j].site + "," + sites[k].site)
            }
            for (t in s) cnt[t] = (cnt[t]?:0)+1
        }
        var mx = 0
        var t = ""
        for ((key, value) in cnt)
            if (mx < value || (mx == value && key < t)) {
                mx = value
                t = key
            }

        return t.split(",".toRegex()).dropLastWhile { it.isEmpty() }
    }

    internal class Node(var user: String, var ts: Int, var site: String)

}