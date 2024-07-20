import java.io.BufferedReader
import java.io.InputStreamReader

// 111. Точки и отрезки

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = reader.readLine().trim().split(' ').map(String::toInt)
    val data = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = reader.readLine().trim().split(' ').map(String::toInt)
        data.add(minOf(a,b) to 0)
        data.add(maxOf(a,b) to 2) }
    val dots = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()
    dots.forEach { data.add(it to 1) }
    data.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
    var cnt = 0
    val res = mutableMapOf<Int,Int>()
    data.forEach {
        when (it.second) {
            0 -> cnt++
            2 -> cnt--
            else -> res[it.first] = cnt
        } }
    println(dots.map{ res[it] }.joinToString(" "))
}