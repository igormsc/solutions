class Solution3258 {
    fun countKConstraintSubstrings(s: String, k: Int): Int {
        var (l,r,o,z,res) = intArrayOf(0,0,0,0,0)
        while (r<s.length) {
            if (s[r] == '0') z++ else o++
            while (z>k && o>k) if (s[l++] == '0') z-- else o--
            res += (r-l+1)
            r++
        }
        return res
    }
}