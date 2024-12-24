class Solution1717 {

    fun maximumGain(s: String, x: Int, y: Int): Int {
        var a = "ab"
        var b = "ba"
        var x = x
        var y = y
        if (x < y) {
            a = b.also { b = a }
            x = y.also { y = x }
        }
        val bs = s.toMutableList()

        fun remove(r: String, x: Int): Int {
            var i = 0
            var res = 0
            (0..bs.lastIndex).forEach { j ->
                bs[i++] = bs[j]
                if (i > 1 && bs[i - 2] == r[0] && bs[i - 1] == r[1]) i -= 2 .also { res += x }
            }
            if (bs.size > i) while (bs.size > i) bs.removeLast()
            else repeat(bs.lastIndex-1){ bs.add(0.toChar()) }

            return res
        }
        return remove (a, x) + remove(b, y)
    }

}
