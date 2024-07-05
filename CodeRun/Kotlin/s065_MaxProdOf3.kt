import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val nums = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    reader.close()

    nums.sort()
    val maybe1 = nums.slice(nums.lastIndex-2..nums.lastIndex)
    val maybe2 = mutableListOf(nums.last()).also{it.addAll(nums.slice(0..1)) }.toList()
    val r = (maybe1.map{it.toLong()}.reduce(Long::times) to maybe2.map{it.toLong()}.reduce(Long::times))
                .let { if (it.first>it.second) maybe1 else maybe2 }

    writer.write(r.joinToString(" "))
    writer.newLine()
    writer.close()
}
