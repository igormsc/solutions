class Solution647 {
    fun countSubstrings(s: String): Int =
        if (s.isEmpty()) 0 else {
            var cnt = 0
            fun f(p: Pair<Int, Int>) {
                var (l, r) = p
                if (s.isNotEmpty() && l <= r) while (l >= 0 && r <= s.lastIndex && s[l--] == s[r++]) cnt++ }
            s.indices.forEach { f(it to it); f(it to it + 1) }
            cnt
        }
}