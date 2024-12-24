class Solution774 {
    fun minmaxGasDist(stations: IntArray, k: Int): Double {
        fun chk(x: Double): Boolean =
            (0..<stations.lastIndex).sumOf{ i -> ((stations[i + 1] - stations[i]) / x).toInt()} <= k

        var (l, r) = 0.0 to 1e8
        while (r - l > 1e-6) {
            val mid = (l + r) / 2.0
            if (chk(mid)) r = mid
            else l = mid
        }
        return l
    }

}