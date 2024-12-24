import java.util.*

class Solution3161 {
    fun getResults(queries: Array<IntArray>): List<Boolean> {
        val o = TreeMap<Int,Int>()
        val res = mutableListOf<Boolean>()
        queries.forEach {q ->
            if (q[0] == 1) {
                val i = q[1]
                var prev = o.lowerKey(i)
                var next = o.higherKey(i)

                if (prev == null) o[i] = i
                else o[i] = maxOf(i-prev, o[prev]!!)
                prev = i
                while (next != null && o[next]!! > o[prev]!!) {
                    o[next] = maxOf(next-prev, o[prev]!!)
                    prev = next
                    next = o.higherKey(next)
                }
            } else {
                val i = q[1]
                val sz = q[2]
                if (o.containsKey(i)) res.add(o[i]!! >= sz)
                else {
                    val prev = o.lowerKey(i)
                    if (prev == null) res.add (i >= sz)
                    else res.add(maxOf(i-prev, o[prev]!!) >= sz)
                }
            }
        }
        return res
    }

}
