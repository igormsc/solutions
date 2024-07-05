import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val tokens = reader.readLine().split(" ").filter { it.isNotBlank() }

    val sl = Solution150()
    val r = sl.evalRPN(tokens)
    writer.write(r.toString())

    reader.close()
    writer.close()
}

// leetcode 150
class Solution150 {
    fun evalRPN(tokens: List<String>): Int = tokens.fold(mutableListOf<Int>()) { st, t ->
        st.add(if (ops.containsKey(t)) (ops[t]!!)(st.removeLast(),st.removeLast()) else t.toInt())
        st }.last()

    private val ops = mapOf("+" to fun(a: Int, b:Int) = a+b, "-" to fun(a: Int, b: Int) = b-a,
        "*" to fun(a: Int, b: Int) = a*b, "/" to fun(a:Int, b: Int) = b/a)
}