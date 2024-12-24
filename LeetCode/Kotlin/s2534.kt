class Solution2534 {

    fun timeTaken(arrival: IntArray, state: IntArray): IntArray {

        val enter = mutableListOf<Event>()
        val exit = mutableListOf<Event>()
        var curTime = 0
        var curQ = exit

        val sz = arrival.size
        val res = IntArray(sz)

        for (i in 0..<sz) {
            val event = Event(i, arrival[i])
            if (state[i] == 0) enter.add(event)
            else exit.add(event)
        }

        fun nxtQ(): MutableList<Event> =
            when {
                enter.isEmpty() -> exit
                exit.isEmpty() -> enter
                enter.first().time < exit.first().time -> enter
                enter.first().time > exit.first().time -> exit
                else -> exit
            }

        while (enter.isNotEmpty() || exit.isNotEmpty()) {
            if (curQ.isEmpty() || curQ.first().time > curTime) {
                curQ = nxtQ()
                curTime = maxOf(curTime, curQ.first().time)
            }
            val nextEvent = curQ.removeFirst()
            res[nextEvent.person] = curTime++
        }

        return res
    }

    internal inner class Event(var person: Int, var time: Int)
}