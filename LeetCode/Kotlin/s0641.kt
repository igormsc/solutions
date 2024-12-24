class MyCircularDeque(k: Int) {

    private val v = IntArray(k)
    private val k = k
    private var cnt = 0
    private var front = k - 1
    private var end = 0

    fun insertFront(value: Int): Boolean =
        if (isFull()) false
        else {
            v[front] = value
            front = (front - 1 + k) % k
            cnt++
            true
        }

    fun insertLast(value: Int): Boolean =
        if (isFull()) false
        else {
            v[end] = value
            end = (end + 1) % k
            cnt++
            true
        }

    fun deleteFront(): Boolean =
        if (isEmpty()) false
        else {
            front = (front + 1) % k
            cnt--
            true
        }

    fun deleteLast(): Boolean =
        if (isEmpty()) false
        else {
            end = (end - 1 + k) % k
            cnt--
            true
        }

    fun getFront(): Int = if (isEmpty()) -1 else v[(front + 1) % k]

    fun getRear(): Int = if (isEmpty()) -1 else v[(end - 1 + k) % k]

    fun isEmpty(): Boolean = cnt == 0

    fun isFull(): Boolean = cnt == k

}
