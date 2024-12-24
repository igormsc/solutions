class FirstUnique(nums: IntArray) {

    private val cnt = mutableMapOf<Int, Int>()
    private val q = mutableListOf<Int>()

    init {
        nums.forEach { n ->
            cnt[n] = (cnt[n]?:0) + 1
            q.add(n)
        }
    }

    fun showFirstUnique(): Int {
        while (q.isNotEmpty() && cnt[q.first()] != 1) q.removeFirst()
        return if (q.isEmpty()) -1 else q.first()
    }

    fun add(value: Int) {
        cnt[value] = (cnt[value]?:0) + 1
        q.add(value)
    }


}