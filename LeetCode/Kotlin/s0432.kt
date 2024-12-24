class AllOne {
    private val head = Bucket(Int.MIN_VALUE)
    private val tail = Bucket(Int.MAX_VALUE)

    private val countBucketMap: MutableMap<Int, Bucket?> = hashMapOf()
    private val keyCountMap: MutableMap<String, Int> = hashMapOf()

    private class Bucket(var count: Int) {
        var keySet = mutableSetOf<String>()
        var next: Bucket? = null
        var pre: Bucket? = null
    }

    init {
        head.next = tail
        tail.pre = head
    }

    fun inc(key: String) {
        if (keyCountMap.containsKey(key))
            changeKey(key, 1)
        else {
            keyCountMap[key] = 1
            if (head.next!!.count != 1) addBucketAfter(Bucket(1), head)
            head.next!!.keySet.add(key)
            countBucketMap[1] = head.next
        }
    }

    fun dec(key: String) {
        if (keyCountMap.containsKey(key)) {
            val count = keyCountMap[key]!!
            if (count == 1) {
                keyCountMap.remove(key)
                removeKeyFromBucket(countBucketMap[count], key)
            } else
                changeKey(key, -1)

        }
    }

    fun getMaxKey(): String = if (tail.pre === head) "" else tail.pre!!.keySet.iterator().next()

    fun getMinKey(): String = if (head.next === tail) "" else head.next!!.keySet.iterator().next()

    private fun changeKey(key: String, offset: Int) {
        val count = keyCountMap[key]!!
        keyCountMap[key] = count + offset
        val curBucket = countBucketMap[count]
        val newBucket =
            if (countBucketMap.containsKey(count + offset))
                countBucketMap[count + offset]
            else {
                val b = Bucket(count + offset)
                countBucketMap[count + offset] = b
                addBucketAfter(b, if (offset == 1) curBucket else curBucket!!.pre)
                b
            }
        newBucket!!.keySet.add(key)
        removeKeyFromBucket(curBucket, key)
    }

    private fun removeKeyFromBucket(bucket: Bucket?, key: String) {
        bucket!!.keySet.remove(key)
        if (bucket.keySet.size == 0) {
            removeBucketFromList(bucket)
            countBucketMap.remove(bucket.count)
        }
    }

    private fun removeBucketFromList(bucket: Bucket?) {
        bucket!!.pre!!.next = bucket.next
        bucket.next!!.pre = bucket.pre
        bucket.next = null
        bucket.pre = null
    }

    private fun addBucketAfter(newBucket: Bucket?, preBucket: Bucket?) {
        newBucket!!.pre = preBucket
        newBucket.next = preBucket!!.next
        preBucket.next!!.pre = newBucket
        preBucket.next = newBucket
    }
}