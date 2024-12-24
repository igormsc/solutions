class TimeMap() {

    private val m = mutableMapOf<String,MutableList<Pair<String,Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        m.computeIfAbsent(key) { mutableListOf() }.add(value to timestamp)
    }

    fun get(key: String, timestamp: Int): String {
        if (!m.containsKey(key)) return ""
        var (l, r) = 0 to m[key]!!.size
        while (l < r) {
            val mid = l + (r-l)/2
            if (m[key]!![mid].second > timestamp) r = mid else l = mid+1
        }
        return if (l in 1..m[key]!!.size) m[key]!![l-1].first else ""
    }

}

