class Solution2868 {
    fun canAliceWin(a: Array<String>, b: Array<String>): Boolean {
        var i = 1
        var j = 0
        var k = true
        var w = a[0]
        while (true) {
            if (k) {
                if (j == b.size) return true
                if ((b[j][0] == w[0] && w < b[j]) || b[j][0].code - w[0].code == 1) {
                    w = b[j]
                    k = !k
                }
                j++
            } else {
                if (i == a.size) return false
                if ((a[i][0] == w[0] && w < a[i]) || a[i][0].code - w[0].code == 1) {
                    w = a[i]
                    k = !k
                }
                i++
            }
        }
    }

}