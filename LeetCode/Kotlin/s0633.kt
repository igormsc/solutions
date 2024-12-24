class Solution633 {
    fun judgeSquareSum(c: Int): Boolean {
        var f = 2
        var c = c
        while (f*f <= c) {
            var ex = 0
            if (c%f == 0) {
                while (c%f == 0) {
                    ex++
                    c /=f
                }
                if (f%4 == 3 && ex%2 != 0) return false
            }
            f++
        }
        return c%4 != 3
    }
}
