import kotlin.math.sign

class Solution165 {
    fun compareVersion(version1: String, version2: String): Int {
        fun cnv(v: String) = v.split('.').map { it.toInt() }
        val n = cnv(version1) to cnv(version2)
        (0..maxOf(n.first.size,n.second.size)).forEach{i ->
            val d = (if(i<n.first.size) n.first[i] else 0) - (if (i<n.second.size) n.second[i] else 0)
            if (d<0) return -1
            if (d>0) return 1
        }
        return 0
    }
}

