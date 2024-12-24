class Solution1538 {
    fun guessMajority(reader: ArrayReader): Int {
        val n: Int = reader.length()
        val x: Int = reader.query(0, 1, 2, 3)
        var (a, b, k) = intArrayOf(1,0,0)
        for (i in 4..<n)
            if (reader.query(0, 1, 2, i) == x) a++
            else {
                b++
                k = i
            }

        val y = reader.query(0, 1, 2, 4)
        if (reader.query(1, 2, 3, 4) == y) a++
        else {
            b++
            k = 0
        }
        if (reader.query(0, 2, 3, 4) == y) a++
        else {
            b++
            k = 1
        }
        if (reader.query(0, 1, 3, 4) == y) a++
        else {
            b++
            k = 2
        }
        if (a == b) return -1
        return if (a > b) 3 else k
    }

    abstract class ArrayReader {
        abstract fun length(): Int
        abstract fun query(a: Int, b: Int, c: Int, d: Int): Int
    }

}

