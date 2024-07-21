import java.io.BufferedReader
import java.io.InputStreamReader

// 132. Коллекционер Диего

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine()
    val nums = reader.readLine().trim().split(' ').map(String::toInt).toSet().toIntArray()
    nums.sort()
    reader.readLine()
    val reject = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    fun bs(v: Int): Int {
        var l = 0
        var r = nums.lastIndex
        var m = 0
        if (v<=nums[l]) return -1
        if (v>nums[r]) return r
        while (l<=r) {
            m = (l+r)/2
            if (nums[m] == v) return m-1
            if (v<nums[m]) r = m-1 else l = m+1
        }
        while (m>=0 && v<nums[m]) m--
        return m
    }
    reject.forEach { println(bs(it) + 1) }
}