class Solution1580 {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val n = warehouse.size
        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = Int.MAX_VALUE/2
        right[n - 1] = Int.MAX_VALUE/2
        for (i in 1..<n)
            left[i] = minOf(left[i - 1], warehouse[i - 1])

        for (i in n - 2 downTo 0)
            right[i] = minOf(right[i + 1], warehouse[i + 1])

        warehouse.indices.forEach { warehouse[it] = minOf(warehouse[it], maxOf(left[it], right[it])) }
        boxes.sort()
        warehouse.sort()

        var i = 0
        var res = 0
        for (x in boxes) {
            while (i < n && warehouse[i] < x) i++
            if (i == n) break
            res++
            i++
        }
        return res
    }

}