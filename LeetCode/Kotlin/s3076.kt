class Solution3076 {
    fun shortestSubstrings(arr: Array<String>): Array<String> {
        val root = Node()

        arr.indices.forEach { i ->
            (0..arr[i].length).forEach { j ->
                var node = root
                (j..<arr[i].length).forEach { k ->
                    val c = arr[i][k].code - 'a'.code
                    if (node.next[c] != null) node.next[c]!!.cnt++
                    else node.next[c] = Node()
                    node = node.next[c]!!
                }
            }
        }

        val res = Array<String>(arr.size) {""}
        arr.indices.forEach { i ->
           // res[i] = ""
            val r = Node()
            (0..<arr[i].length).forEach { j ->
                var node = root
                var snode = r
                for (k in j..<arr[i].length) {
                    val c = arr[i][k].code - 'a'.code

                    if (snode.next[c] == null) snode.next[c] = Node()
                    else snode.next[c]!!.cnt++
                    snode = snode.next[c]!!

                    if (node.next[c] == null) continue
                    if (node.next[c]!!.cnt <= snode.cnt) {
                        val ln = k-j+1
                        val q = arr[i].substring(j, k+1)
                        if (res[i] === "" || q.length < res[i].length || q.length == res[i].length && q < res[i]) res[i] = q
                    } else node = node.next[c]!!
                }
            }
        }
        return res
    }

    private class Node {
        var next: Array<Node?> = arrayOfNulls(26)
        var cnt: Int = 0
    }

}

