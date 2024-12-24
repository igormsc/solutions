class Solution214 {
    fun shortestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        val n = s.length
        val (d1, d2) = IntArray(n) to IntArray(n)
        var (l,r) = 0 to -1
        s.indices.forEach { i ->
            var k = if (i>r)  1 else minOf(d1[l+r-i], r-i+1)
            while (i-k >= 0 && i+k < n && s[i+k] == s[i-k]) k++
            d1[i] = k--
            if (i+k>r) { l = i-k; r = i+k }
        }
        l = 0
        r = -1
        s.indices.forEach { i ->
            var k = if (i>r) 0 else minOf(d2[l+r-i+1], r-i+1)
            while (i-k-1 >= 0 && i+k < n && s[i-k-1] == s[i+k]) k++
            d2[i] = k--
            if (i+k>r) {l=i-k-1; r=i+k}
        }
        var mx = 0
        s.indices.forEach { i ->
            if (d1[i] == i+1) mx = maxOf(mx, 2*d1[i]-1)
            if (d2[i] == i) mx = maxOf(mx, 2*d2[i])
        }
        val sb = StringBuilder()
        (s.lastIndex downTo  mx).forEach { sb.append(s[it]) }
        sb.append(s)
        return sb.toString()
    }

}
