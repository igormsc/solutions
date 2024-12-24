import java.util.*

class StatisticsTracker() {

    val q = mutableListOf<Int>()
    val pq = PriorityQueue<Pair<Int,Int>> { a, b -> if (a.first == b.first) a.second-b.second else b.first-a.first}
    var n = 0
    var s = 0L
    var cnt = mutableMapOf<Int,Int>()
    val lst = mutableListOf<Int>()
    var fSrt = false

    fun addNumber(number: Int) {
        lst.add(number)
        fSrt = false
        cnt[number] = (cnt[number] ?: 0) + 1
        pq.add(cnt[number]!! to number)
        s += number.toLong()
        q.add(number)
        n++
    }

    fun removeFirstAddedNumber() {
        val v = q.removeFirst()
        lst.remove(v)
        fSrt = false
        cnt[v] = (cnt[v] ?: 0) - 1
        s -= v.toLong()
        n--
    }

    fun getMean(): Int = (s / n.toLong()).toInt()

    fun getMedian(): Int  {
        if (!fSrt) lst.sort()
        return lst[n/2]
    }

    fun getMode(): Int {
        while (pq.isNotEmpty() && pq.peek().first != cnt[pq.peek().second] ) pq.poll()
        return pq.peek().second
    }

}
