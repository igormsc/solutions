class Solution3348 {
    fun smallestNumber(num: String, t: Long): String {
        var t = t
        val bs = num.toCharArray()
        val n = bs.size
        val remind = LongArray(n + 1).also { it[0] = t }
        var end = n
        for (i in 0..<n) {
            if (bs[i] == '0') {
                end = i + 1
                break
            }
            remind[i + 1] = remind[i] / gcd(remind[i], (bs[i].code - '0'.code).toLong())
        }
        if (end == n && remind[n] == 1L) return num
        for (i in end - 1 downTo 0) {
            while (bs[i] < '9') {
                var z = remind[i]
                bs[i]++
                z /= gcd(z, (bs[i].code - '0'.code).toLong())
                for (j in n - 1 downTo i + 1)
                    for (k in 9 downTo 1)
                        if (z % k == 0L) {
                            z /= k.toLong()
                            bs[j] = ('0'.code + k).toChar()
                            break
                        }
                if (z == 1L) return String(bs)
            }
        }
        val sb = StringBuilder()
        var i = 9
        while (t > 1 && i > 1) {
            while (t % i == 0L) {
                sb.append(i)
                t /= i.toLong()
            }
            i--
        }
        if (t != 1L) return "-1"
        val res = sb.reverse().toString()
        if (chk(res, num)) return res
        if (res.length == num.length) return "1$res"
        val dif = num.length - res.length
        return if (chk("1".repeat(dif) + res, num)) "1".repeat(dif) + res else "1".repeat(dif + 1) + res
    }

    private fun gcd(a: Long, b: Long): Long = if (a == 0L) b else gcd(b % a, a)
    private fun chk(a: String, b: String): Boolean =
        when {
            a.length > b.length -> true
            a.length < b.length -> false
            else -> a > b
        }

}
