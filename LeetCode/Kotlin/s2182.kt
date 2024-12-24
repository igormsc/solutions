class Solution2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val cnt = s.fold(IntArray(26)) { r, c -> r[c.code-'a'.code]++; r}
        return buildString {
            var (i, j) = 25 to 26
            while (j>=0) {
                while (i>=0 && cnt[i]==0) i--
                if (i>=0) append( (i+'a'.code).toChar().toString()
                                .repeat(minOf(repeatLimit - if (i==j) 1 else 0, cnt[i]).also{cnt[i]-=it}))
                j = minOf(i-1, j)
                while (j>=0 && cnt[j]==0) j--
                if (j>=0) append( (j + 'a'.code).toChar()).also { cnt[j]-- }
            }
        }
    }
}
