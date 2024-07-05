import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    reader.readLine()
    val nums = reader.readLine().toCharArray().filter { it.isDigit() }.toMutableList()
    reader.close()

    fun isPalindrome(s: List<Char>): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i++] != s[j--]) return false
        }
        return true
    }

    val extra = mutableListOf<Char>()
    while (nums.isNotEmpty())
        if (isPalindrome(nums)) break else extra.add(nums.removeFirst())

    extra.reverse()

    writer.write(extra.size.toString())
    writer.newLine()
    writer.write(extra.joinToString(" "))
    writer.newLine()
    writer.close()
}