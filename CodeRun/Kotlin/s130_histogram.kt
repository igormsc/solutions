import java.io.File

// 130. Гистограмма

fun main(args: Array<String>) {

    val cnt = mutableMapOf<Char,Int>()

    File("input.txt").forEachLine { line ->
        val l = line.toCharArray().filter{ !it.isWhitespace()}
        l.forEach { cnt[it] = (cnt[it]?: 0) + 1 }
    }

    val keys = cnt.keys.toList().sorted()
    (cnt.values.max() downTo 1).forEach { h ->
        val ht = cnt.filter {it.value >= h}.keys
        val sb = StringBuilder()
        keys.forEach { sb.append(if (ht.contains(it)) "#" else " ")}
        println(sb.toString())
    }
    println(keys.joinToString(""))
}