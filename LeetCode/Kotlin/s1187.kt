class Solution1187 {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        arr2.sort()
        var q = 0
        for (x in arr2)
            if (q == 0 || x != arr2[q - 1]) arr2[q++] = x

        val mx = Int.MAX_VALUE / 2
        val arr = IntArray(arr1.size + 2).also { it[0] = -mx; it[it.lastIndex] = mx }
        arr1.copyInto(arr, 1, 0, arr1.size)
        val d = IntArray(arr.size){mx}.also{it[0]=0}

        fun search(x: Int, n: Int): Int {
            var (l, r) = 0 to n
            while (l < r) {
                val m = (l + r) / 2
                if (arr2[m] >= x) r = m else l = m + 1
            }
            return l
        }

        for (i in 1..arr.lastIndex) {
            if (arr[i - 1] < arr[i]) d[i] = d[i - 1]
            val j = search(arr[i], q)
            for (k in 1..minOf(i - 1, j))
                if (arr[i - k - 1] < arr2[j - k])
                    d[i] = minOf(d[i], d[i - k - 1] + k)
        }
        return if (d[arr.lastIndex] >= mx) -1 else d[arr.lastIndex]
    }

}

