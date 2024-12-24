class Solution1518 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int = numBottles + (numBottles-1)/(numExchange-1)

}