class MyCircularQueue(k: Int) {
    private val q = IntArray(k)
    private var front = 0
    private var end = -1
    private var size = 0
    private var k = k

    fun enQueue(value: Int): Boolean =
        if (isFull()) false else {
            end = (end+1)%k
            q[end] = value
            size++
            true
        }

    fun deQueue(): Boolean =
        if (isEmpty()) false else {
            front = (front+1)%k
            size--
            true
        }

    fun Front(): Int = if (isEmpty()) -1 else q[front]

    fun Rear(): Int = if (isEmpty()) -1 else q[end]

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == k

}
