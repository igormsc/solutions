import java.io.BufferedReader
import java.io.InputStreamReader

// 97. Робот

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (k, s) = reader.readLine().trim().toInt() to reader.readLine().trim()
    reader.close()

    var prev = 0L
    println(
        (k..s.lastIndex)
            .sumOf { if (s[it] == s[it-k]) ++prev else  0L.also{prev = 0L} })
}
