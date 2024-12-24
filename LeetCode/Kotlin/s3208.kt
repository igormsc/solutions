class Solution3208 {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        var cnt = 1
        val n = colors.size
        return (1..n+k-2).count { i ->
            cnt = if (colors[i%n] != colors[(n+i-1)%n]) cnt+1 else 1
            cnt>=k
        }
    }
}