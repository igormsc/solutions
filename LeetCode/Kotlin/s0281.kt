class ZigzagIterator {
    private var cur = 0
    private val sz = 2
    private val idx = mutableListOf<Int>(0,0)
    private val vec = mutableListOf<List<Int>>()

    constructor(v1: IntArray, v2: IntArray) {
        vec.add(v1.toList())
        vec.add(v2.toList())
    }

    fun next(): Int {
        val i = idx[cur]
        val res = vec[cur][i]
        idx[cur] = i + 1
        cur = (cur + 1) % sz
        return res
    }

    fun hasNext(): Boolean {
        val start = cur
        while (idx[cur] == vec[cur].size) {
            cur = (cur + 1) % sz
            if (start == cur) return false
        }
        return true
    }

}
