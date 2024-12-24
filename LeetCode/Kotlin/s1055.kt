class Solution1055 {
    fun shortestWay(source: String, target: String): Int {
        val (m, n) = source.length to target.length
        var res = 0
        var j = 0
        while (j < n) {
            var i = 0
            var flg = true
            while (i < m && j < n)
                if (source[i++] == target[j]) flg = false.also{j++}
            if (flg) return -1
            res++
        }
        return res
    }

}