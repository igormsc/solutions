class Solution3365 {
    fun isPossibleToRearrange(s: String, t: String, k: Int): Boolean {
        val l = s.length/k
        val cnt = (0..s.lastIndex step l).fold(mutableMapOf<String,Int>() to mutableMapOf<String,Int>()) { r, i ->
                    s.slice(i..<i+l).let { x -> r.first[x] = (r.first[x]?:0) + 1 }
                    t.slice(i..<i+l).let { x -> r.second[x] = (r.second[x]?:0) + 1 }
                    r }
        cnt.first.forEach{ (k,v) -> if (cnt.second[k] != v) return false}
        return true
    }
}
