import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine()
    reader.close()
    var i = 0
    var j = s.lastIndex
    var isPalindrome = true
    while (i < j) {
        while (s[i] == ' ') i++
        while (s[j] == ' ') j--
        if (s[i++].lowercaseChar() != s[j--].lowercaseChar()) {
            isPalindrome = false
            break
        }
    }

    writer.write(if (isPalindrome) "It is a palindrome" else "It is not a palindrome")
    writer.close()
}