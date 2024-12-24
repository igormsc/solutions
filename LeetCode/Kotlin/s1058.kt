import java.text.DecimalFormat

class Solution1058 {
    fun minimizeError(prices: Array<String>, target: Int): String {
        var mi = 0
        val a = mutableListOf<Double>()
        for (p in prices) {
            val price = p.toDouble()
            mi += price.toInt()
            val d = price - price.toInt()
            if (d > 0) a.add(d)
        }
        if (target < mi || target > mi + a.size) return "-1"
        val d = target - mi
        a.sortDescending()
        var res = d.toDouble()
        (0..<d).forEach { res -= a[it] }
        for (i in d..a.lastIndex) res += a[i]
        return "%,.3f".format(res)
    }

}
