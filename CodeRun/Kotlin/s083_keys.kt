import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine()
    val cnt = reader.readLine().trim().split(" ").map(String::toInt).toIntArray()
    reader.readLine()
    val press = reader.readLine().trim().split(" ").map(String::toInt)
    press.forEach { cnt[it-1]-- }
    cnt.forEach { println(if (it<0) "YES" else "NO") }

    reader.close()
}
