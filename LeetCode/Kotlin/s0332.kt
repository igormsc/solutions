class Solution332 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val res = mutableListOf<String>()
        val gr = mutableMapOf<String,MutableList<String>>()
        tickets.forEach { t ->
            val l = gr[t[0]] ?: mutableListOf()
            val i = l.binarySearch(t[1]).let { if (it < 0) -(it+1) else it }
            l.add(i, t[1])
            gr[t[0]] = l
        }

        fun dfs (vtex: String) {
            while (gr[vtex] != null && gr[vtex]!!.isNotEmpty()) {
                val to = gr[vtex]!!.removeAt(0)
                dfs(to)
            }
            res.add(vtex)
        }
        dfs("JFK")
        res.reverse()
        return res

    }
}
