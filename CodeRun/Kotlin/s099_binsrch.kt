import java.io.BufferedReader
import java.io.InputStreamReader

// 99. Двоичный поиск

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = reader.readLine().trim().split(' ').map(String::toInt)
    val sq1 = reader.readLine().trim().split(' ').map(String::toInt)
    val sq2 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    fun bs(x: Int): Boolean {
        var l = -1
        var r = n
        while (r-l>1) {
            val m = (r+l)/2
            if (sq1[m]==x) return true
            if (sq1[m]>x) r = m else l = m
        }
        return false
    }
    sq2.forEach{ println(if (bs(it)) "YES" else "NO")}
}