class Solution702 {
    fun search(reader: ArrayReader, target: Int): Int {
        var r = 1
        while (reader.get(r) < target) r = r.shl(1)
        var l = r.shr(1)

        while (l < r) {
            val mid = (l + r)/2
            if (reader.get(mid) >= target) r = mid
            else l = mid + 1
        }
        return if (reader.get(l) == target) l else -1
    }

}

abstract class ArrayReader {
    abstract fun get(index: Int): Int
}



