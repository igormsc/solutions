class ExamRoom(n: Int) {
    private val num = n
    private val v = mutableListOf<Int>()

    fun seat(): Int {
        if (v.isEmpty()) {
            v.add(0)
            return 0
        }
        var d = maxOf(v.first(), num-1-v.last())
        (0..<v.lastIndex).forEach { i -> d = maxOf(d, (v[i+1]-v[i])/2 )}
        if (v.first() == d) {
            v.add(0,0)
            return 0
        }
        (0..<v.lastIndex).forEach { i ->
            if ((v[i+1] - v[i])/2 == d) {
                v.add(i+1, (v[i+1]+v[i])/2)
                return v[i+1]
            }
        }
        v.add(num-1)
        return v.last()
    }

    fun leave(p: Int) {
        v.indices.forEach { i ->
            if (v[i] == p) {
                v.removeAt(i)
                return
            }
        }
    }

}

