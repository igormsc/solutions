import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

// 90. Стильная одежда

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine().trim()
    val sq1 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.readLine().trim()
    val sq2 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    val delta = mutableMapOf<Int,Pair<Int,Int>>()
    var i = 0
    var j = 0

    while (i < sq1.lastIndex || j < sq2.lastIndex) {
        if (i<sq1.lastIndex && (sq1[i]<sq2[j] ||  j==sq2.lastIndex)) i++ else j++
        delta[(sq1[i]-sq2[j]).absoluteValue] = i to j
    }
    println(delta[delta.keys.min()]!!.let { v -> "${sq1[v.first]} ${sq2[v.second]}" })
}