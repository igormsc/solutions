import java.util.*

class Solution1516 {
    fun moveSubTree(root: Node?, p: Node?, q: Node?): Node? {
        val v = parent(root, p)
        if (v != q) {
            val z = parent(p,q)
            if (z != null) rm(z, q, null)
            rm(v, p, if(z !=null) q else null)
            val c = q!!.children.toMutableList()
            c.add(p)
            q.children = c
        }
        return if (root==p) q else root
    }

    private fun parent(r: Node?, t: Node?): Node? {
        var p: Node? = null
        var i = 0
        while (i < r!!.children.size && p == null) {
            p = if (r.children[i] == t) r else parent(r.children[i], t)
            i++
        }
        return p
    }

    private fun rm(r: Node?, t: Node?, m: Node?) {
        if (r != null) {
            var i = 0
            while (i < r.children.size) {
                if (r.children[i] == t)
                    if (m != null) {
                        val x = r.children.toMutableList()
                        x[i] = m
                        r.children = x
                    } else {
                        val x = r.children.toMutableList()
                        x.removeAt(i)
                        r.children = x.toList()
                    }
                i++
            }
        }
    }

}
