class Solution1243 {
    fun transformArray(arr: IntArray): List<Int> {
        var f = true
        while (f) {
            f = false
            val t = arr.clone()
            for (i in 1..<t.lastIndex) {
                if (t[i] > t[i - 1] && t[i] > t[i + 1]) {
                    arr[i]--
                    f = true
                }
                if (t[i] < t[i - 1] && t[i] < t[i + 1]) {
                    arr[i]++
                    f = true
                }
            }
        }
        return arr.toList()
    }

}