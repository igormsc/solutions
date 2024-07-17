import java.io.BufferedReader
import java.io.InputStreamReader

// 4. Ход конём

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = reader.readLine().trim().split(' ').map(String::toInt)
    reader.close()

    val dp = Array(n + 1) { LongArray(m + 1) } .also{ it[0][0] = 1 }

    (0..<n-1).forEach { i ->
        (0..<m-1).forEach { j ->
            dp[i + 2][j + 1] += dp[i][j]
            dp[i + 1][j + 2] += dp[i][j]
        }
    }
    println(dp[n-1][m-1])
}
