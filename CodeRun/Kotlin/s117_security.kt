import java.io.BufferedReader
import java.io.InputStreamReader

// 117. Охрана

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val k = reader.readLine().trim().toInt()
    val res = mutableListOf<Boolean>()
    repeat (k) {
        val nums = reader.readLine().trim().split(' ').map(String::toInt).drop(1)
        val n = nums.size /2
        var j = 0
        val events = nums.foldIndexed(mutableListOf<Triple<Int, Int, Int>>()) { i, r, n ->
                        r.add(Triple(n, i%2 , j)); j += i%2; r }
        events.sortWith(compareBy<Triple<Int, Int, Int>> {it.first}.thenBy{it.second}.thenBy {it.third})
        val s1 = mutableSetOf<Int>()
        val s2 = mutableSetOf<Int>()
        var flg = true
        var prev = -1
        for (e in events) {
            if (e.first!=0 && s2.isEmpty()) {flg = false; break}
            if (s2.size == 1 && e.first != prev) s1.addAll(s2)
            if (e.second == 0) s2.add(e.third) else s2.remove(e.third)
            prev = e.first
        }
        if (prev != 10000) flg = false
        res.add(flg && s1.size == n)
    }
    res.forEach{println(if (it) "Accepted" else "Wrong Answer")}
    reader.close()
}