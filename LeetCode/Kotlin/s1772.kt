import java.util.*

class Solution1772 {
    fun sortFeatures(features: Array<String>, responses: Array<String>): Array<String> {
        val cnt = mutableMapOf<String, Int>()
        for (s in responses) {
            val vis = mutableSetOf<String>()
            for (w in s.split(" "))
                if (vis.add(w)) cnt.merge(w, 1) { a: Int, b: Int -> a+b}
        }

        val n = features.size
        val u = Array(n) {it}
        Arrays.sort(u) { i: Int, j: Int ->
            val x = cnt[features[i]]?:0
            val y = cnt[features[j]]?:0
            if (x == y) i - j else y - x
        }
        return Array(n) {features[u[it]]}
    }

}
