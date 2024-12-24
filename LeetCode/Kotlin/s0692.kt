class Solution692 {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val fr = words.fold(mutableMapOf<String,Int>()) { r, w -> r[w] = (r[w]?:0) + 1; r}
        val res =  mutableListOf<Pair<Int,String>>()
        fr.forEach { (k ,v) -> res.add(Pair(v,k)) }
        return res.sortedWith(compareBy<Pair<Int, String>> {it.first}.thenBy { it.second }).take(minOf(res.lastIndex, k)).map{it.second}
    }
}
