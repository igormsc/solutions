class Solution1564 {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val n = warehouse.size
        val left = IntArray(n)
        left[0] = warehouse[0]
        for (i in 1..<n) left[i] = minOf(left[i - 1], warehouse[i])
        boxes.sort()
        var (i, j) = 0 to n - 1
        while (i < boxes.size) {
            while (j >= 0 && left[j] < boxes[i]) j--
            if (j < 0) break
            i++
            j--
        }
        return i
    }

}