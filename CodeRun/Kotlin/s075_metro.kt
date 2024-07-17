import java.io.BufferedReader
import java.io.InputStreamReader

// 75. Метро

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = (0..3).fold(IntArray(4)) { r, i -> r[i] = reader.readLine().trim().toInt(); r }
    reader.close()

    val (l, r) = maxOf(n[2]+n[0]*(n[2]-1), n[3]+n[1]*(n[3]-1)) to minOf(n[2]+n[0]*(n[2]+1), n[3]+n[1]*(n[3]+1))
    println(if (l>r) "-1" else "$l $r")

}
