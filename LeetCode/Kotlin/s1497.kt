class Solution1497 {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val frq = arr.fold(IntArray(k)) { r, a ->
            var b = a%k
            if (b<0) b+=k
            r[b]++
            r }
        if (frq[0]%2!=0) return false
        for (i in 1..k/2) if (frq[i]!=frq[k-i]) return false
        return true
    }
}
