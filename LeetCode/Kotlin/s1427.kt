class Solution1427 {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var x = 0
        shift.forEach { e ->
            if (e[0] == 0) e[1] *= -1
            x += e[1]
        }
        val n = s.length
        x = (x % n + n) % n
        return s.substring(n - x) + s.substring(0, n - x)
    }

}