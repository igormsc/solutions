import java.util.*

class matrix3D(n: Int) {

    val m = mutableMapOf<Int,MutableSet<Pair<Int, Int>>>()
    val frq = TreeSet { a:Pair<Int,Int>, b:Pair<Int,Int> -> if (a.first == b.first) b.second-a.second else b.first-a.first }
    val n = n - 1

    fun setCell(x: Int, y: Int, z: Int) {
        if ( !(m.containsKey(x) && m[x]!!.contains(y to z)) ) {
            m.computeIfAbsent(x) { mutableSetOf() }.add(Pair(y, z))
            val sz = m[x]!!.size
            frq.remove(sz-1 to x)
            frq.add(sz to x)
        }
    }

    fun unsetCell(x: Int, y: Int, z: Int) {
        if (m.containsKey(x) && m[x]!!.contains(y to z)) {
            m[x]!!.remove(y to z)
            val sz = m[x]!!.size
            frq.remove(sz+1 to x)
            if (sz>0) frq.add(sz to x)
        }
    }

    fun largestMatrix(): Int = if (frq.isEmpty()) n else frq.first().second

}