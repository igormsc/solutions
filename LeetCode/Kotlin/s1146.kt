
import java.util.*
import java.util.function.IntFunction

class SnapshotArray(length: Int) {
    private val arr = Array(length) { mutableListOf<IntArray>() }
    private var i = 0

    fun set(index: Int, `val`: Int) {
        arr[index].add(intArrayOf(i, `val`))
    }

    fun snap(): Int = i++

    fun get(index: Int, snap_id: Int): Int {
        var (l, r) = 0 to arr[index].size
        while (l < r) {
            val m = (l + r) / 2
            if (arr[index][m][0] > snap_id) r = m else l = m+1
        }
        return if (--l<0) 0 else arr[index][l][1]
    }
}
