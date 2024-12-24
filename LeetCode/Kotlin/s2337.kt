class Solution2337 {
    fun canChange(start: String, target: String): Boolean {
        var (i, j) = 0 to 0
        val n = start.length
        while (i < n || j < n) {
            while (i < n && start[i] == '_') i++
            while (j < n && target[j] == '_') j++
            if (i == n || j == n || start[i] != target[j] || (start[i] == 'L' && i < j) || (start[i] == 'R' && i > j)) break
            i++
            j++
        }
        return i == n && j == n
    }
}
