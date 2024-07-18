import java.io.BufferedReader
import java.io.InputStreamReader

// 5. Кафе

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt() + 1
    val nums = (1..<n).fold(mutableListOf<Int>()) { r, _ -> r.add(reader.readLine().trim().toInt()); r}
    reader.close()

    val dp = Array(n+1) { IntArray(n+1) { -1 } }

    val prices = if (nums.size>0)  mutableListOf(0, nums[0]) else mutableListOf(0)
    if (n>1) if (prices[1]>100) dp[1][1] = prices[1] else dp[1][0] = prices[1]

    (2..<n).forEach { day ->
        val cost = nums[day-1]
        prices.add(cost)

        (0..<n).forEach { coupon ->
            dp[day][coupon] =
            minOf(
                minOf(
                    if (cost>0 && dp[day-1][coupon+1]>=0) dp[day-1][coupon+1] else Int.MAX_VALUE,
                    if (cost<=100 && dp[day-1][coupon]>=0) dp[day-1][coupon] + cost else Int.MAX_VALUE),
                    if (coupon > 0 && cost>100 && dp[day-1][coupon-1]>=0) dp[day-1][coupon-1] + cost else Int.MAX_VALUE)
                .let {if (it==Int.MAX_VALUE) -1 else it}
        }
    }

    var currI = 0
    var minTotal = Int.MAX_VALUE

    (n-1 downTo 0).forEach { coupon ->
        if (dp[n-1][coupon] in 1..minTotal) { minTotal = dp[n-1][coupon].also { currI = coupon } } }

    var left = currI
    var used = 0
    val couponDays = mutableListOf<Int>()

    for (day in n-1 downTo 1) {
        if (currI >=0 && currI+1>n) continue
        if (dp[day][currI] == dp[day-1][currI+1]) {
            used++
            currI++
            couponDays.add(day)
        } else if (currI >0 && dp[day][currI] == dp[day-1][currI-1] + prices[day]) currI--
    }

    if (minTotal == Int.MAX_VALUE) minTotal = 0
    if (left<=0) left = 0

    println(minTotal)
    println("$left $used")
    println(couponDays.reversed().joinToString("\n"))
}