class Solution3345 {
    fun smallestNumber(n: Int, t: Int): Int {
        fun chk(n: Int): Boolean {
            var (n, p) = n to 1
            while (n > 0) p *=(n%10).also{n /= 10}
            return p%t == 0
        }
        return (n..n+9).find { chk(it) }?:-1
    }
}
