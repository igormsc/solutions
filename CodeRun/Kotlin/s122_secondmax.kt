import java.io.BufferedReader
import java.io.InputStreamReader

// 122. Второй максимум

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val nums = reader.readLine().trim().split(' ').map(String::toInt).dropLast(1)
    reader.close()

    println(
        nums.fold(Int.MIN_VALUE to Int.MAX_VALUE){ r, n ->
            when {
                n > r.first -> n to r . first
                n > r.second && n != r.first -> r.first to n
                else -> r
            }
        }.second
    )
}

