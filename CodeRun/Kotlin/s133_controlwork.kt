import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

// 133. Контрольная работа

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val k = reader.readLine().trim().toInt()
    val r = reader.readLine().trim().toInt()
    val s = reader.readLine().trim().toInt()
    reader.close()

    val seat = 2*r - if (s==1) 2 else 1
    val (dl, dr) = seat + k to seat - k
    
    val res =
    if (dl >= n && dr < 0 ) "-1"
    else {
        val (x, y) = ((dl.toDouble()+1.0)/2.0).roundToInt() to ((dr.toDouble()+1.0)/2.0).roundToInt()
        val (u, v) = (if (dl%2==1) 2 else 1) to if (dr%2==1) 2 else 1
        when {
            dl >= n -> "$y $v"
            dr < 0 -> "$x $u"
            x - r > r - y -> "$y $v"
            else -> "$x $u"
        }
    }
    println(res)
}
