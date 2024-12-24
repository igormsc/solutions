class Solution544 {
    fun findContestMatch(n: Int): String {
        var n = n
        val s = Array(n) { (it+1).toString() }
        while (n > 1) {
            for (i in 0..<n/2)
                s[i] = String.format("(%s,%s)", s[i], s[n - i - 1])
            n /= 2
        }
        return s[0]
    }

}