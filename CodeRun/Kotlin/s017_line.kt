import java.io.BufferedReader
import java.io.InputStreamReader

// 17. Конвейер

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    repeat(reader.readLine().trim().toInt()) {
        val pr = reader.readLine().trim().split(' ').drop(1).map(String::toDouble)
        val q = mutableListOf<Double>()
        val st = mutableListOf<Double>()
        var res = ""
        for (p in pr) {
            while (q.isNotEmpty() && q.last()<p && (st.isEmpty() || q.last()>=st.last())) st.add(q.removeLast())
            if (st.isNotEmpty() && st.last() > p) { res = "0"; break }
            q.add(p) }
        if (res != "0")
            while (q.isNotEmpty()) {
                if (st.isNotEmpty() && q.last()<st.last()) { res = "0"; break }
                st.add(q.removeLast()) }
        if (res.isEmpty()) res = "1"
        println(res)
    }
    reader.close()
}