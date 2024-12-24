class Solution367 {
    fun isPerfectSquare(num: Int): Boolean {
        val num = num.toLong()
        var x = num
        while (x*x>num.toLong())
            x = (x+num/x)/2
        return x*x == num
    }
}
