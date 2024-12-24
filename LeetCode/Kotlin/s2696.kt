class Solution2696 {
    fun minLength(s: String): Int {
        var j = 0
        val bs = s.toCharArray()
        bs.indices.forEach { i ->
            bs[j] = bs[i]
            if (j>0 && (bs[j-1] == 'A' || bs[j-1] == 'C') && bs[j-1] == bs[j]-1) j-- else j++
        }
        return j
    }
}
