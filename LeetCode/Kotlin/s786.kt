class Solution786 {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        var l = 0.0
        var r = 1.0
        while (l < r) {
            val m = (l + r) / 2
            var maxF = 0.0
            var p = 0
            var q = 0
            var j = 1
            var total = 0
            for (i in 0..<n-1) {
                while (j < n && arr[i].toDouble() > m * arr[j].toDouble()) j++
                total += n-j
                if (j==n) break
                val f = arr[i].toDouble() / arr[j].toDouble()
                if (f > maxF) {
                    maxF = f
                    p = i
                    q = j
                }
            }
            if (total == k) return intArrayOf(arr[p], arr[q])
            if (total > k) r = m else l = m
        }
        return intArrayOf()
    }
}

