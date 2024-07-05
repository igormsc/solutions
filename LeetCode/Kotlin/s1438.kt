fun main() {

    val sl = Solution1438();

    val nums = intArrayOf(10,1,2,4,7,2)
    val  limit = 5

    println(sl.longestSubarray(nums, limit))
}

class Solution1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int =
        nums.fold(Triple(mutableListOf<Int>(), mutableListOf<Int>(), 0)) { (maxD, minD, i), n ->
            while (maxD.isNotEmpty() && n > maxD.last()) maxD.removeLast()
            while (minD.isNotEmpty() && n < minD.last()) minD.removeLast()
            maxD.add(n)
            minD.add(n)
            (if (maxD.first() - minD.first() > limit) {
                if (maxD.first() == nums[i]) maxD.removeFirst()
                if (minD.first() == nums[i]) minD.removeFirst()
                1 } else 0)
                .let { Triple(maxD, minD, i + it)}
        }.let { nums.size - it.third }
}

