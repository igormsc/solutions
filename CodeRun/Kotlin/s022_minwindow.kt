import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = reader.readLine().trim().split(' ').map(String::toInt).toIntArray()

    val sl = Solution239m()
    sl.minSlidingWindow(nums, k).forEach { println(it) }

    reader.close()
}

// leetcode 239 modified

class Solution239m {
    fun minSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxLR =
            (1..<nums.size)
                .fold( Pair(IntArray(nums.size), IntArray(nums.size))
                    .also { it.first[0] = nums[0]; it.second[it.second.lastIndex] = nums.last() }
                ) { m,  i ->
                    val j = nums.size - i - 1
                    m.first[i] = if (i%k == 0) nums[i] else minOf(m.first[i-1], nums[i])
                    m.second[j] = if (j%k == 0) nums[j] else minOf(m.second[j+1], nums[j])
                    m
                }
        return (0..nums.size-k)
            .map{i -> minOf(maxLR.second[i], maxLR.first[i+k-1]) }
            .toIntArray()
    }
}