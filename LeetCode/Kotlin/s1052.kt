class Solution1052 {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var l = 0
        var r = 0
        var maxUnsatisfied = 0
        var unSatisfied = 0
        var satisfied = 0
        while (r<grumpy.size) {
            if (grumpy[r] != 0) unSatisfied += customers[r++] else satisfied += customers[r++]
            if (r-l>minutes) l++ .also {if (grumpy[it] != 0) unSatisfied -= customers[it]}
            maxUnsatisfied = maxOf(maxUnsatisfied, unSatisfied)
        }
        return satisfied + maxUnsatisfied
    }
}
