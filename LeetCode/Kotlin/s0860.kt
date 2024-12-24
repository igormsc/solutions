class Solution860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        var five = 0
        var ten = 0
        bills.forEach { b ->
            when  {
                b == 5 -> five++
                b == 10 -> {five--; ten++}
                ten > 0 -> {ten--; five--}
                else -> five -=3
            }
            if (five < 0) return false
        }
        return true
    }
}
