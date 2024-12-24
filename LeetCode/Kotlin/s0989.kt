class Solution989 {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val res = mutableListOf<Int>()
        var v = 0
        var k = k
        var i = num.lastIndex
        while (i>=0 || k>0) {
            if (i>=0) {
                v = (num[i]+k)%10
                k = (num[i]+k)/10
            } else {
                v = k%10
                k /=10
            }
            res.add(v)
            i--
        }
        i = 0
        var j = res.lastIndex
        while (i<j) {
            res[i] = res[j].also{res[j] = res[i]}
            i++
            j--
        }
        return res.toList()
    }
}
