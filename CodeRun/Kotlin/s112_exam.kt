import java.io.BufferedReader
import java.io.InputStreamReader

// 112. Рассадка в аудитории

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (_, d) = reader.readLine().trim().split(' ').map(String::toInt)
    val nums = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    val events = nums.fold(mutableListOf<Pair<Int,Int>>()) { r, v -> r.add(v to 0); r.add(v + d to 1); r}
    events.sortWith(compareBy({ it.first }, { it.second }))
    var max = 0
    var cnt = 0
    events.forEach { (_, e) -> if (e==0) max = maxOf(max, ++cnt) else cnt-- }
    cnt = 1
    val res = events.fold(mutableMapOf<Int,Int>()) { r, (x, e) -> if (e==0) { r[x] = cnt; if (cnt<max) cnt++ else cnt = 1 }; r}
    println(max)
    println(nums.map { v -> res[v] }.joinToString(" "))
}