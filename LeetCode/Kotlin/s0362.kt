class HitCounter() {

    private val ts = mutableListOf<Int>()

    fun hit(timestamp: Int) {
        ts.add(timestamp)
    }

    fun getHits(timestamp: Int): Int = ts.size - search(timestamp - 300 + 1)

    private fun search(x: Int): Int {
        var (l, r) = 0 to ts.size
        while (l < r) {
            val mid = (l + r)/2
            if (ts[mid] >= x) r = mid
            else l = mid + 1
        }
        return l
    }


}
