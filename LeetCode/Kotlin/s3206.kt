class Solution3206 {
    fun numberOfAlternatingGroups(colors: IntArray): Int {
        var cnt = 1
        val n = colors.size
        return (1..n+1).fold(0) { r, i ->
            cnt = if (colors[i%n] != colors[(n+i-1)%n]) cnt+1 else 1
            r + if (cnt>=3) 1 else 0
        }
    }
}
