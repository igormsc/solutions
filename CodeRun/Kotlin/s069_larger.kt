import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val nums = reader.readLine().split(' ').map(String::toInt)
    reader.close()

    (1..<nums.lastIndex).count{ nums[it-1] < nums[it] && nums[it+1] < nums[it] }.also { print(it) }

}