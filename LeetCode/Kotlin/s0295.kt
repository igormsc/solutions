import java.util.*

class MedianFinder() {

    private val mn = PriorityQueue<Int>()
    private val mx = PriorityQueue(Collections.reverseOrder<Int>())

    fun addNum(num: Int) {
        mx.offer(num)
        mn.offer(mx.poll())
        if (mn.size - mx.size > 1) mx.offer(mn.poll())
    }

    fun findMedian(): Double =
        if (mn.size == mx.size) (mn.peek() + mx.peek()) / 2.0 else mn.peek().toDouble()

}

