import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = reader.readLine().trim().split(" ").map(String::toInt)

    val intervals = (1..m).fold(mutableListOf<IntArray>()) { r, _ ->
        val rng = reader.readLine().split(' ').map(String::toInt)
        r.add(intArrayOf(rng[0], rng[1]))
        r }.toTypedArray()

    val sl = Solution56()
    val i = sl.merge(intervals)
    val r = n - i.sumOf { it[1] - it[0] + 1}
    println(r)

    reader.close()
}


// leetcode 56 https://leetcode.com/problems/merge-intervals/
class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })
        var i = 0
        val n = intervals.lastIndex
        (1..n).forEach { j ->
            if (intervals[j][0] > intervals[i][1]) {i++ ;intervals[i] = intervals[j]}
            else if (intervals[i][1] < intervals[j][1]) intervals[i][1] = intervals[j][1]
        }
        return if (n>i) intervals.slice(0..intervals.lastIndex-n+i).toTypedArray() else intervals
    }
}