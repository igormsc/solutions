import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine()
    reader.close()

    var prev = false
    val v = s.foldIndexed(mutableListOf<MutableList<Char>>()) { i, r, c ->
        if (c.isDigit()) r.last().add(c) else if (prev) r.add(mutableListOf('0')) else {if (i>0) r.add(mutableListOf('1')); r.add(mutableListOf('0'))}
        prev = c.isDigit()
        r }
    if (s.length > 1 && !s.last().isDigit()) v.add(mutableListOf('1'))

    val cnt = if (s.length == 1) 1 else v.sumOf { it.joinToString("").toInt() }

    writer.write(cnt.toString())
    writer.newLine()
    writer.close()
}