class Solution3100 {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int =
        generateSequence(numBottles to numExchange) {(i, e) -> i - e + 1 to e+1 }.takeWhile { it.first >= it.second }.count() + numBottles

}
