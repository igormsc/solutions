import java.io.BufferedReader
import java.io.InputStreamReader

// 55. Злые свинки

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val s = mutableSetOf<Int>()
    val r =  (1..n).count {
        val (x, y) = reader.readLine().trim().split(' ').map(String::toInt)
        s.add(x) }
    println(r)
    reader.close()
}