import java.io.BufferedReader
import java.io.InputStreamReader

// 94. Красота превыше всего

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    var l = 0
    val cnt = mutableMapOf<Int, Int>()
    var resL = 0
    var resR = n - 1
    var min = n

    (0..<n).forEach { r ->
        cnt[nums[r]] = (cnt[nums[r]] ?: 0) + 1
        while ((cnt[nums[l]] ?: 0) > 1) {
            cnt[nums[l]] = (cnt[nums[l]] ?: 0) - 1
            l++
        }

        if (cnt.size == k) {
            val len = r - l + 1
            if (len < min) {
                min = len
                resL = l
                resR = r
            }
        }
    }
    println("${resL+1} ${resR+1}")
}