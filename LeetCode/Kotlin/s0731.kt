class MyCalendarTwo() {

    private var root: Node? = null

    fun book(start: Int, end: Int): Boolean {
        if (query(root, start, end) >= 2) return false
        root = update(root, start, end)
        return true
    }

    private class Node(var start: Int, var end: Int, var k: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    private fun query(r: Node?, start: Int, end: Int): Int =
        when {
            start >= end || r == null -> 0
            r.start >= end -> query(r.left, start, end)
            r.end <= start -> query(r.right, start, end)
            else -> maxOf(r.k, query(r.left, start, end), query(r.right, start, end))
        }

    private fun update(r: Node?, start: Int, end: Int): Node? =
        when {
            start >= end -> r
            r == null -> Node(start, end, 1)
            else -> {
                when {
                    r.end <= start -> r.right = update(r.right, start, end)
                    r.start >= end -> r.left = update(r.left, start, end)
                    else -> {
                        val a = minOf(start, r.start)
                        val b = maxOf(start, r.start)
                        val c = minOf(end, r.end)
                        val d = maxOf(end, r.end)
                        r.start = b
                        r.end = c
                        r.k++
                        r.left = update(r.left, a, b)
                        r.right = update(r.right, c, d)
                    }
                }
                r }
        }
}

