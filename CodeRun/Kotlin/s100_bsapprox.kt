import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

// 100. Приближенный двоичный поиск

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = reader.readLine().trim().split(' ').map(String::toInt)
    val sq1 = reader.readLine().trim().split(' ').map(String::toInt)
    val sq2 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    fun sbs(x: Int, low: Boolean): Int {
        var l = -1
        var r = n
        while (r-l>1) {
            val m = (l+r)/2
            if (low) if (sq1[m] >= x) r = m else l = m
            else if (sq1[m] >= x) r = m else l = m
        }
        return if (low)  r else l
    }

    fun bs(x: Int): Int {
        val (l,r) = sbs(x, false) to sbs(x, true)
        return when {
                    l <= -1 -> r
                    r >= n -> l
                    ((sq1[l] - x).absoluteValue > (sq1[r] - x).absoluteValue) -> r
                    else -> l }
    }

    sq2.forEach{ println(sq1[bs(it)]) }
}