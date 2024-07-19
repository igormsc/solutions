import java.io.BufferedReader
import java.io.InputStreamReader

// 6. НОП с восстановлением ответа

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine().trim()
    val sq1 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.readLine().trim()
    val sq2 = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    val dp =
        sq1.indices.fold(Array(sq1.size+1) {IntArray(sq2.size+1)}) { dp,  i1 ->
            sq2.indices.forEach { i2 ->
                if (sq1[i1] == sq2[i2]) dp[i1+1][i2+1] = dp[i1][i2] + 1
                else dp[i1+1][i2+1] = maxOf(dp[i1][i2+1], dp[i1+1][i2]) }; dp }

    val res = mutableListOf<Int>()
    fun build(s1: Int, s2: Int): Unit {
        when {
            dp[s1][s2] == 0 -> {}
            sq1[s1 - 1] == sq2[s2 - 1] -> build(s1 - 1, s2 - 1).also{ res.add(sq1[s1 - 1]) }
            dp[s1 - 1][s2] > dp[s1][s2 - 1] -> build(s1 - 1, s2)
            else -> build(s1, s2 - 1)
        }
    }
    build(sq1.size, sq2.size)
    println(res.joinToString(" "))
}