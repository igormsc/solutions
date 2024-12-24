class Solution050 {
    fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var x = x
        var p = if (n<0) -n.also{ x = 1 / x} else n
        while (p != 0) {
            if (p%2 != 0 ) res *= x
            x *=x
            p /= 2
        }
        return res
    }
}