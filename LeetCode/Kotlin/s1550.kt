class Solution1550 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var odds = 0
        return arr.find { n ->
            if (n.and(1) == 1) odds++ else odds = 0
            odds == 3 } != null
    }
}

