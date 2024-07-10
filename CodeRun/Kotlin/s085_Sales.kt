import java.io.*
import java.util.TreeMap

fun main(args: Array<String>) {

    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val m: MutableMap<String,MutableMap<String,Long>> = TreeMap()
    File("input.txt").forEachLine { line ->
        val (c, p, q) = line.split(' ')
        m.computeIfAbsent(c) { TreeMap() }
        m[c]?.set(p, (m[c]?.get(p) ?:0) + q.toLong())
    }

    m.forEach{ (c, x) ->
            writer.write("$c:\n")
            x.forEach{(p, q) -> writer.write("$p $q\n") }
        }

    writer.flush()
    writer.close()
}