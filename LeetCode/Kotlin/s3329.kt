class Solution3329 {
    fun numberOfSubstrings(s: String, k: Int): Long {
        val cnt = IntArray('z'.code+1)
        var (l,r) = 0 to -1
        val n = s.length
        var res = 0L
        while (++r < n) {
            cnt[s[r].code]++
            while (l<=r && cnt[s[r].code] >=k) {
                res += (n-r).toLong()
                cnt[s[l++].code]--
            }
        }
        return res
    }
}