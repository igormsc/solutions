class Solution3241 {

    fun timeTaken(edges: Array<IntArray>): IntArray {
        val sub = IntArray(100_000)
        val out = IntArray(100_000)

        val n = edges.size + 1
        val adj = Array(n) { mutableListOf<Int>() }
        edges.forEach { e ->
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        fun clcSub(src: Int, pr: Int) {
            for (ch in adj[src])
                if (ch != pr) {
                    clcSub(ch, src)
                    val dist = sub[ch] + if (ch % 2 == 0) 2 else 1
                    sub[src] = maxOf(sub[src], dist)
                }
        }
        clcSub(0, -1)

        fun clcOut(src: Int, par: Int) {
            var max1 = 0
            var max2 = 0
            for (ch in adj[src])
                if (ch != par) {
                    val dist = sub[ch] + (2 - ch % 2)
                    if (dist >= max1) {
                        max2 = max1
                        max1 = dist
                    } else max2 = maxOf(dist,max2)
                }

            for (ch in adj[src])
                if (ch != par) {
                    val max = out[src] + 2 - src % 2
                    out[ch] = if (2 - ch % 2 + sub[ch] == max1) maxOf(max, max2 + 2 - src % 2)
                    else maxOf(max, max1 + 2 - src % 2)
                    clcOut(ch, src)
                }
            }
        clcOut(0, -1)

        val time = IntArray(n)
        for (i in 0..<n) time[i] = maxOf(out[i], sub[i])
        return time
    }

}