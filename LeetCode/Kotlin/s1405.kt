import java.util.*

class Solution1405 {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val pq = PriorityQueue<Pair<Int,Char>> { o1, o2 -> if (o1.first == o2.first) o1.second.code - o2.second.code else o1.first - o2.first }
        if (a!=0) pq.add(a to 'a')
        if (b!=0) pq.add(b to 'b')
        if (c!=0) pq.add(c to 'c')
        val res = StringBuilder()
        while (pq.size > 1) {
            var (oF, oS) = pq.poll()
            var (tF, tS) = pq.poll()
            if (oF >= 2) {
                res.append(oS)
                res.append(oS)
                oF -=2
            } else {
                res.append(oS)
                oF--
            }
            if (tF >= 2 && tF >= oF) {
                res.append(tS)
                res.append(tS)
                tF -=2
            } else {
                res.append(tS)
                tF--
            }
            if (oF > 0) pq.add(oF to oS)
            if (tF > 0) pq.add(tF to tS)
        }
        if (pq.isEmpty()) return res.toString()
        if (pq.peek().first >= 2) {
            res.append(pq.peek().second)
            res.append(pq.peek().second)
        } else {
            res.append(pq.peek().second)
        }
        return res.toString()
    }
}
