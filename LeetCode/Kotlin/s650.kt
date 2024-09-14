class Solution650 {
    private val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
    fun minSteps(n: Int): Int =
        when {
            n == 1 -> 0
            n <= 5 -> n
            else -> primes.find { n % it == 0 }.let { if (it!=null) it+minSteps(n/it) else n }
        }

}