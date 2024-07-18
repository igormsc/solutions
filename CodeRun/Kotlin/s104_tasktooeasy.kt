import java.io.BufferedReader
import java.io.InputStreamReader

// 104. Очень лёгкая задача

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    var (n,x,y) = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    n--
    var l = -1
    var r = n*maxOf(x,y)+1
    while (r-l>1) {
        val m = (l+r)/2
        if (m/x + m/y >=n) r = m else l = m
    }
    println(minOf(x,y)+r)
}
