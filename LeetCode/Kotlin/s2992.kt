class Solution2992 {
    fun selfDivisiblePermutationCount(n: Int): Int = count(mutableListOf(), BooleanArray(n + 1))

    fun count(st: MutableList<Int>, vis: BooleanArray): Int {
        var cnt = 0
        if (vis.lastIndex == st.size) return 1
        (1..vis.lastIndex).forEach { i ->
            if (!vis[i] && gcd(i, st.size + 1) == 1) {
                vis[i] = true
                st.add(i)
                cnt += count(st, vis)
                st.removeLast()
                vis[i] = false
            }
        }
        return cnt
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}