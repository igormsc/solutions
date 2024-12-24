fun main() {
    val sl = Solution950()
    var deck = intArrayOf(17,13,11,2,3,5,7)
    println(sl.deckRevealedIncreasing(deck))
}

class Solution950 {
    fun deckRevealedIncreasing(deck: IntArray): IntArray =
        deck.sortedDescending().fold(mutableListOf<Int>()) { r, d ->
            if (r.isNotEmpty()) r.add(r.removeFirst())
            r.add(d)
            r
        }.reversed()
         .toIntArray()

}
