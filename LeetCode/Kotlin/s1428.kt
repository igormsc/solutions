class Solution1428 {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (m, n) = binaryMatrix.dimensions()
        return (0..<m).minOf { i ->
                    var (l, r) = 0 to n
                    while (l < r) {
                        val mid = (l + r) / 2
                        if (binaryMatrix.get(i, mid) == 1) r = mid else l = mid + 1 }
                    l }.let { if (it >= n) -1 else it }
    }

}

abstract class BinaryMatrix {
    abstract fun get(i: Int, j: Int): Int
    abstract fun dimensions(): List<Int>
}