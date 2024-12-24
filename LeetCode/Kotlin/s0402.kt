class Solution402 {
    fun removeKdigits(num: String, k: Int): String {
        val res = mutableListOf<Char>()
        var k = k
        num.forEach { c ->
            while (res.isNotEmpty() && res.last() > c && k != 0) res.removeLast().also { k-- }
            if (res.isNotEmpty() || c != '0') res.add(c)
        }
        while (res.isNotEmpty() && k >0) res.removeLast().also { k-- }
        return if (res.isNotEmpty()) res.joinToString("") else "0"
    }
}

