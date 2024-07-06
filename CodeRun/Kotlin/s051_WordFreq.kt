import java.io.*


fun main(args: Array<String>) {

    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val freq = mutableMapOf<String, Int>()
    val res = mutableListOf<Int>()
    File("input.txt").forEachLine { line ->
        line.split(" ").filter{it.isNotBlank()}.forEach{ w ->
            val f = freq.getOrDefault(w, 0)
            res.add(f)
            freq[w] = f + 1
        }
    }

    writer.write(res.joinToString(" "))
    writer.newLine()
    writer.close()
}