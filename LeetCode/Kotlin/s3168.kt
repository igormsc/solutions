class Solution3168 {
    fun minimumChairs(s: String): Int = s.fold(0 to 0) { (m, cnt), c -> if (c == 'E') maxOf(m, cnt+1) to cnt + 1 else m to cnt - 1 }.first
}
