import java.io.BufferedReader
import java.io.InputStreamReader

// 98. Треугольники

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n =reader.readLine().trim().toInt()
    val crds = (0..<n).fold(mutableListOf<Pair<Long,Long>>()) { r, _ ->
        r.add(reader.readLine().trim().split(' ').map(String::toLong).let{it[0] to it[1]}); r}
    reader.close()

    val res =
    (0..<n).fold(0L){ t, i ->
        val nb = mutableListOf<Long>()
        val s = mutableSetOf<Pair<Long,Long>>()
        val a = (0..<n).count{ j ->
                    val x = crds[i].first - crds[j].first
                    val y = crds[i].second - crds[j].second
                    nb.add(x*x + y*y)
                    s.contains(x to y).also{s.add(-x to -y)} }
        nb.sort()
        var r = 0
        nb.indices.sumOf { l ->
            while (r<nb.size && nb[l] == nb[r]) r++
            (r-l-1).toLong() } + t - a
    }
    println(res)
}