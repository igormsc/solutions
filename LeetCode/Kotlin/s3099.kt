class Solution3099 {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        var n = x
        var sum = 0
        while (n > 0) sum += (n%10).also { n /= 10 }
        return if (x%sum == 0) sum else -1
    }
}
