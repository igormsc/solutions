class Solution1087 {
    fun expand(s: String): Array<String> {
        val res = mutableListOf<String>()
        val items = mutableListOf<Array<String>>()

        fun convert(s: String) {
            if (s == "") return
            if (s[0] == '{') {
                val j = s.indexOf("}")
                items.add(s.substring(1, j).split(",").toTypedArray())
                convert(s.substring(j + 1))
            } else {
                val j = s.indexOf("{")
                if (j != -1) {
                    items.add(s.substring(0, j).split(",").toTypedArray())
                    convert(s.substring(j))
                } else
                    items.add(s.split(",").toTypedArray())
            }
        }

        convert(s)

        fun dfs(i: Int, t: MutableList<String>) {
            if (i == items.size) {
                res.add(t.joinToString(""))
                return
            }
            items[i].forEach {
                t.add(it)
                dfs(i + 1, t)
                t.removeLast()
            }
        }

        dfs(0, mutableListOf())

        res.sort()
        return res.toTypedArray()
    }

}