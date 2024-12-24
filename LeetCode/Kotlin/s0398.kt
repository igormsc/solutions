import kotlin.random.Random

class Solution398(nums: IntArray) {

    val indexes = mutableMapOf<Int,MutableList<Int>>()
    val rnd = Random(System.currentTimeMillis())

    init {
        nums.forEachIndexed { i, num -> indexes.computeIfAbsent(num) { mutableListOf() }.add(i)  }
    }

    fun pick(target: Int): Int =
        if (indexes.contains(target)) {
            val v = indexes[target]!!
            v[rnd.nextInt(v.size)]
        } else -1

}
