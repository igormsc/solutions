import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine().toCharArray()
    reader.close()

    var n = 0
    s.forEach { if (n > 0 && (it-s[n-1]+1)/2 == 1) n-- else  s[n++] = it  }

    writer.write(if (n==0) "yes" else "no")
    writer.newLine()
    writer.close()
}
