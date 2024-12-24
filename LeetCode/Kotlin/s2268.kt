class Solution2268 {
    fun minimumKeypresses(s: String): Int {
        val cnt = IntArray(26)
        s.forEach { cnt[it.code - 'a'.code]++ }
        cnt.sort()
        var k = 1
        var res = 0
        for (i in 1..26) {
            res += k * cnt[26 - i]
            if (i % 9 == 0) k++
        }
        return res
    }

}