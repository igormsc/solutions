class CustomStack(maxSize: Int) {

    private var index = -1
    private val inc = IntArray(maxSize)
    private val stack = mutableListOf<Int>()

    fun push(x: Int) {
        if (stack.size == inc.size) return
        stack.add(x)
        index++
    }

    fun pop(): Int {
        if (index == -1) return -1
        val r = stack.removeLast() + inc[index]
        if (index > 0) inc[index-1] += inc[index]
        inc[index--] = 0
        return r
    }

    fun increment(k: Int, `val`: Int) {
        if (index == -1) return
        if (stack.size < k) inc[index] += `val`
        else inc[k-1] += `val`
    }

}
