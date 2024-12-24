class Solution2647 {
    fun colorRed(n: Int): Array<IntArray> {
        val res = mutableListOf(intArrayOf(1, 1))
        var i = n
        var k = 0
        while (i > 1) {
            if (k == 0) {
                var j = 1
                while (j < i shl 1) {
                    res.add(intArrayOf(i, j))
                    j += 2
                }
            } else if (k == 1) res.add(intArrayOf(i, 2))
            else if (k == 2) {
                var j = 3
                while (j < i shl 1) {
                    res.add(intArrayOf(i, j))
                    j += 2
                }
            } else res.add(intArrayOf(i, 1))
            i--
            k = (k + 1) % 4
        }
        return res.toTypedArray()
    }

}