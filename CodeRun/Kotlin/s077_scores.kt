import java.io.BufferedReader
import java.io.InputStreamReader

// 77. Улучшение успеваемости

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val a = reader.readLine().trim().toLong()
    val b = reader.readLine().trim().toLong()
    val c = reader.readLine().trim().toLong()

    var l = 0L
    var r = (1E16).toLong()
    val (preS, preT) = a*2 + b*3 + c*4 to a+b+c
    while (l<r) {
        val m = (l + r) / 2
        if ( ((preS + m*5))*2 < (preT+m)*7)  l = m+1 else r = m
    }
    println(l)

    reader.close()
}