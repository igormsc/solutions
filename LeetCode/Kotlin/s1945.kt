class Solution1945 {
    fun getLucky(s: String, k: Int): Int {
        var (sum, sum1) = 0 to 0
        for (c in s) ( c.code - 'a'.code + 1 ).also{ sum += it/10 + it%10}
        var k = k - 1
        while (k-- >0 && sum > 9) {
            while (sum>0) sum1 += sum%10 .also {sum /=10}
            sum = sum1
            sum1 = 0
        }
        return sum
    }
}