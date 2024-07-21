import java.io.BufferedReader
import java.io.InputStreamReader

// 134. Хорошая строка

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val nums = (0..<n).fold(mutableListOf<Int>()) { r, _ -> r.add(reader.readLine().trim().toInt()); r}
    reader.close()
    var prev = nums.removeFirst()
    val r = nums.sumOf { curr -> minOf(prev,curr).toLong().also { prev = curr } }
    println(r)
}
