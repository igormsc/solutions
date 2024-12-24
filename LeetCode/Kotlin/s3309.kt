class Solution3309 {
    fun maxGoodNumber(nums: IntArray): Int =
        nums.sortedWith { a: Int, b: Int ->
                    val (bA, bB) = a.toString(2) to b.toString(2)
                    (bB + bA).compareTo(bA + bB) }
            .fold(StringBuilder()) { sb, n -> sb.append(n.toString(2)) }.toString().toInt(2)

}