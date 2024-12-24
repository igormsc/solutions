class Solution3310 {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val adj = Array(n) { mutableListOf<Int>() }
        invocations.forEach { adj[it[0]].add(it[1]) }

        val vis = BooleanArray(n)
        fun bfs(k: Int) {
            vis[k] = true
            val st = mutableListOf(k)
            while (st.isNotEmpty()) {
                val top = st.removeFirst()
                for (ad in adj[top])
                    if (!vis[ad]) {
                        vis[ad] = true
                        st.add(ad)
                    }
            }
        }
        bfs(k)

        for (i in 0..<n)
            if (!vis[i])
                for (ad in adj[i])
                    if (vis[ad]) {
                        val list: MutableList<Int> = ArrayList()
                        for (i1 in 0..<n)
                            list.add(i1)
                        return list
                    }
        return vis.withIndex().filter { !it.value }.map{it.index}
    }


}
