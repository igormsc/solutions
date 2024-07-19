import java.io.BufferedReader
import java.io.InputStreamReader

// 91. Сумма номеров

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    var l = 0
    var r = 0
    var cnt = 0
    var sum = nums.first()

    var nxtL = false
    var nxtR = false

    while (true) {
        when {
            sum == k -> {
                cnt++
                nxtL = true
                nxtR = true }
            sum > k -> nxtL = true.also { if (l == r) nxtR = true }
            else -> nxtR = true
        }
        if (nxtR) {
            if (r < nums.lastIndex) {
                nxtR = false
                r++
                sum += nums[r]
            } else break
        }
        if (nxtL) {
            nxtL = false
            sum -= nums[l++]
        }
    }

    print(cnt)
}