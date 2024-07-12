import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, l) =  reader.readLine().trim().split(" ").map(String::toInt)

    val nums =  (1..n).fold(mutableListOf<IntArray>()) { r, i ->
        r.add(reader.readLine().trim().split(' ').map(String::toInt).toIntArray())
        r }

    (0..<nums.lastIndex).forEach { i ->
        (i+1..nums.lastIndex).forEach { j ->
            val a = nums[i].toMutableList()
            a.addAll(nums[j].toList())
            a.sort()
            println(a[l-1])
        }
    }

    reader.close()
}
