import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val p1 = reader.readLine().split(' ').map(String::toInt).toMutableList()
    val p2 = reader.readLine().split(' ').map(String::toInt).toMutableList()

    var cnt = 0

    while (p1.isNotEmpty() && p2.isNotEmpty() && cnt < 1_000_000) {
        cnt++
        val c1 = p1.removeFirst()
        val c2 = p2.removeFirst()
        when {
            c1 == 9 && c2 == 0 -> {  p2.add(c1); p2.add(c2) }
            c2 == 9 && c1 == 0 -> { p1.add(c1); p1.add(c2) }
            c1 > c2 -> { p1.add(c1); p1.add(c2) }
            c2 > c1 -> {  p2.add(c1); p2.add(c2) }
            else -> {p1.add(c1); p2.add(c2) }
        }
    }
    val r =
        when {
            p1.isEmpty() && p2.isNotEmpty() -> "second $cnt"
            p1.isNotEmpty() && p2.isEmpty() -> "first $cnt"
            else -> "botva"
        }
    println(r)

    reader.close()
}