class UndergroundSystem() {
    private val m = mutableMapOf<Int,Pair<String,Int>>()
    private val stats = mutableMapOf<String,Pair<Int,Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        m[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (startStation, timeIn) = m[id]!!
        val route = "${startStation}#${stationName}"
        var (totalDuration, tripsCnt) = stats[route]?:Pair(0,0)
        stats[route] = totalDuration + t - timeIn to ++tripsCnt
    }

    fun getAverageTime(startStation: String, endStation: String): Double =
        (stats["${startStation}#${endStation}"]?:Pair(0,0)).let{ it.first.toDouble() / it.second.toDouble()}

}
