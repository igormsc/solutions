class Solution846 {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        hand.sort()
        val groups = Array(hand.size/groupSize) { IntArray(2) }
        for (i in hand.indices) {
            for (j in 0..groups.size) {
                if (j == groups.size) return false
                if (groups[j][1] == 0 || (groups[j][1] < groupSize && groups[j][0] == hand[i]-1)) {
                    groups[j][0] = hand[i]
                    groups[j][1]++
                    break
                }
            }
        }
        return true
    }

}
