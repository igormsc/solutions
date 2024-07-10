import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine()
    var nums = reader.readLine().split(' ').map(String::toInt).toMutableList()
    val n = nums.size
    val q = mutableListOf<Int>()

    var curr = 1
    while (curr <= n) {
        val cnt = nums.withIndex().find { it.value == curr }?.index
        if (cnt != null) repeat(cnt + 1) { q.add(nums.removeFirst()!!) }
        if (q.last() != curr) break
        while (q.isNotEmpty() && q.last() == curr) { q.removeLast(); curr++ }
    }
    println(if (curr == n+1) "YES" else "NO")

    reader.close()
}