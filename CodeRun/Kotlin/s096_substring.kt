import java.io.BufferedReader
import java.io.InputStreamReader

// 96. Подстрока

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(' ').map(String::toInt)
    val s = reader.readLine().trim()
    reader.close()

    var i = 0
    var l = 0
    var j = 0
    val cnt = mutableMapOf<Char,Int>()

    (0..<n).forEach { r ->
        if (cnt.containsKey(s[r])) {
            if (cnt[s[r]]!! == k) {
                while (s[l] != s[r]) cnt[s[l]] = (cnt[s[l++]]?:0) - 1
                cnt[s[l]] = (cnt[s[l++]]?:0) - 1
            }
            cnt[s[r]] = cnt[s[r]]!! + 1
        } else cnt[s[r]] = 1
        val x = r - l + 1
        if (x>i) i = x.also{j = l}
    }
    println("$i ${j+1}")
}