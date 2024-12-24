class Solution1963 {
    fun minSwaps(s: String): Int {
        var cnt = 0
        var (i, j) = -1 to s.lastIndex
        var res = 0
        while (++i<j) {
            if (s[i] == '[') cnt++ else cnt--
            if (cnt == -1) {
                while (s[j] == ']') j--
                cnt = 1
                res++
            }
        }
        return res
    }
}
