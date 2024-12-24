class Solution484 {
    fun findPermutation(s: String): IntArray {
        val n = s.length
        val res = IntArray(n + 1) {it+1}

        var i = 0
        while (i < n) {
            var j = i
            while (j < n && s[j] == 'D') j++
            res.reverse(i,j+1)
            i = maxOf((i + 1), j)
        }
        return res
    }

}