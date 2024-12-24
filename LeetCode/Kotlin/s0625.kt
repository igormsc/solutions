class Solution625 {
    fun smallestFactorization(num: Int): Int {
        var num = num
        if (num < 2) return num
        var res = 0L
        var mul = 1L
        for (i in 9 downTo 2)
            if (num % i == 0)
                while (num % i == 0) {
                    num /= i
                    res += mul * i
                    mul *= 10
                }

        return if (num < 2 && res <= Int.MAX_VALUE.toLong()) res.toInt() else 0
    }

}