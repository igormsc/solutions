import java.util.*

class FileSharing(m: Int) {

    private var cur = 0
    private val ts = TreeSet<Int>()
    private val tm = TreeMap<Int, MutableSet<Int>>()

    fun join(ownedChunks: List<Int>?): Int {
        val userID: Int
        if (ts.isEmpty()) {
            cur++
            userID = cur
        } else userID = ts.pollFirst()!!

        tm[userID] = ownedChunks!!.toMutableSet()
        return userID
    }

    fun leave(userID: Int) {
        ts.add(userID)
        tm.remove(userID)
    }

    fun request(userID: Int, chunkID: Int): List<Int> {
        if (chunkID < 1) return listOf()

        val res = mutableListOf<Int>()
        for ((key, value) in tm)
            if (value.contains(chunkID)) res.add(key)

        if (res.isNotEmpty())
            tm.computeIfAbsent(userID) { mutableSetOf() }.add(chunkID)
        return res
    }

}
