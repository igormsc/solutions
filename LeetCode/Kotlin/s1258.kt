class Solution1258 {
    fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
        val res =  mutableListOf<String>()
        val t = mutableListOf<String>()

        val ss = mutableSetOf<String>()
        for (pairs in synonyms) ss.addAll(pairs)
        val words = ss.toList()
        val n = words.size

        val d = mutableMapOf<String,Int>()
        words.forEachIndexed{i, w -> d[w] = i }

        val uf = UnionFind(n)
        for (pairs in synonyms)
            uf.union(d[pairs[0]]!!, d[pairs[1]]!!)

        val g = Array(n) { mutableListOf<Int>() }
        for (i in 0..<n) g[uf.find(i)].add(i)

        for (e in g) e.sortWith { i: Int?, j: Int? -> words[i!!].compareTo(words[j!!]) }

        val sentence = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }

        fun dfs(i: Int) {
            if (i >= sentence.size) {
                res.add(t.joinToString(" "))
                return
            }
            if (!d.containsKey(sentence[i])) {
                t.add(sentence[i])
                dfs(i + 1)
                t.removeLast()
            } else
                for (j in g[uf.find(d[sentence[i]]!!)]) {
                    t.add(words[j])
                    dfs(i + 1)
                    t.removeLast()
                }
        }

        dfs(0)
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int) {
            val (pa, pb) = find(a) to find(b)
            if (pa != pb) {
                if (size[pa] > size[pb]) {
                    p[pb] = pa
                    size[pa] += size[pb]
                } else {
                    p[pa] = pb
                    size[pb] += size[pa]
                }
            }
        }
    }

}