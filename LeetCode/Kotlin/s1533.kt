class Solution1533 {
    fun getIndex(reader: ArrayReader): Int {
        var (l, r) = 0 to reader.length() - 1
        while (l < r) {
            val t1 = l
            val t2 = l + (r - l) / 3
            val t3 = l + (r - l) / 3 * 2 + 1
            when (reader.compareSub(t1, t2, t2 + 1, t3)) {
                0 -> l = t3 + 1
                1 -> r = t2
                else -> {
                    l = t2 + 1
                    r = t3
                }
            }
        }
        return l
    }

    abstract class ArrayReader {
        abstract fun length(): Int
        abstract fun compareSub(l: Int, r: Int, x: Int, y: Int): Int
    }

}

