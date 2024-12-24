class Solution3307 {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        val n = operations.size
        val k = k - 1
        var res = 0
        var i = 0
        while (i<n && i<60) {
            if (k.shr(i)%2>0) res +=operations[i]
            i++
        }
        return ('a'.code + res%26).toChar()
    }
}
