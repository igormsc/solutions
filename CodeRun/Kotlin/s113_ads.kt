import java.io.BufferedReader
import java.io.InputStreamReader

// 113. Реклама

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val nums = (0..<n).fold(Array(n) { listOf<Int>() }) { r, i ->
        r[i] = reader.readLine().trim().split(' ').map(String::toInt);r
    }

    val tmAd = 5
    val events = nums.indices.fold(mutableListOf<Triple<Int, Int, Int>>()) { r, i ->
        if (nums[i][1] - nums[i][0] >= tmAd) {
            r.add(Triple(nums[i][0], 0, i))
            r.add(Triple(nums[i][1] - tmAd, 1, i))
        }; r
    }

    events.sortWith(compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second })
    val ln = events.size
    when {
        ln == 0 -> println("0 $tmAd ${tmAd * 2}")
        ln == 2 -> println("1 ${events[0].first} ${events[0].first + tmAd}")
        else -> {
            var res = 0
            var b1 = 0
            var b2 = 0
            val s = mutableSetOf<Int>()
            events.forEachIndexed { i, e1 ->
                if (e1.second == 0) {
                    s.add(e1.third)
                    if (s.size > res) {
                        res = s.size
                        b1 = e1.first
                        b2 = e1.first + tmAd
                    }
                }
                var cnt = 0
                (i + 1..<ln).forEach { j ->
                    val e2 = events[j]
                    if (e2.second == 0 && !s.contains(e2.third)) cnt++
                    if (e2.first - e1.first >= tmAd && s.size + cnt > res) {
                        res = s.size + cnt
                        b1 = e1.first
                        b2 = e2.first
                    }
                    if (e2.second == 1 && !s.contains(e2.third)) cnt--
                }
                if (e1.second == 1) s.remove(e1.third)
            }
            println("$res $b1 $b2")
        }
    }
    reader.close()
}