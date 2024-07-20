import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val data =
    (1..n).fold(mutableListOf<Pair<Int,Int>>()) { r, _ ->
        val x = reader.readLine().trim().split(' ').map(String::toInt)
        val (o, c) = x[0]*60+x[1] to x[2]*60+x[3]
        if (o>=c) {r.add(0 to 0); r.add(1440 to 1)}
        r.add(o to 0); r.add(c to 1); r }
    reader.close()
    data.sortWith(compareBy<Pair<Int,Int>> { it.first }.thenBy { it.second })
    var cnt = 0
    var res = 0
    data.indices.forEach {
        if (cnt == n) res += data[it].first - data[it-1].first
        cnt += if (data[it].second == 0) 1 else -1 }
    println(res)
}