import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine()
    val nums = reader.readLine().split(' ').map(String::toInt).toSet()
    val s = nums.sumOf{it.toLong()}
    println(s)
    reader.close()
}