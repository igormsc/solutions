import java.util.*

class Solution3245 {
    fun numberOfAlternatingGroups(colors: IntArray, queries: Array<IntArray>): List<Int> {
        val count = Arr(colors.size+1)
        val sum = Arr(colors.size+1)
        val set = TreeSet<Int>()
        val list = ArrayList<Int>()

        fun add(x: Int, n: Int) {
            set.add(x)
            if (set.size == 1) {
                count.update(n, 1)
                sum.update(n, n)
            }
            val prev = if (set.lower(x) == null) set.last() else set.lower(x)
            val next = if (set.higher(x) == null) set.first() else set.higher(x)

            count.update(if (set.size == 2) n else (next - prev + n) % n, -1)
            sum.update(if (set.size == 2) n else (next - prev + n) % n, if (set.size == 2) -n else -(next - prev + n) % n)
            count.update((x - prev + n) % n, 1)
            sum.update((x - prev + n) % n, (x - prev + n) % n)
            count.update((next - x + n) % n, 1)
            sum.update((next - x + n) % n, (next - x + n) % n)
        }

        fun remove(x: Int, n: Int) {
            if (set.size == 1) {
                count.update(n, -1)
                sum.update(n, -n)
            }
            val prev = if (set.lower(x) == null) set.last() else set.lower(x)
            val next = if (set.higher(x) == null) set.first() else set.higher(x)

            count.update(if (set.size == 2) n else (next - prev + n) % n, 1)
            sum.update(if (set.size == 2) n else (next - prev + n) % n, if (set.size == 2) n else (next - prev + n) % n)
            count.update((x - prev + n) % n, -1)
            sum.update((x - prev + n) % n, -(x - prev + n) % n)
            count.update((next - x + n) % n, -1)
            sum.update((next - x + n) % n, -(next - x + n) % n)
            set.remove(x)
        }

        for (i in colors.indices) if (colors[i] == colors[(i + 1) % colors.size]) add(i, colors.size)

        for (query in queries)
            if (query[0] == 1) list.add(if (set.isEmpty()) colors.size else sum.sumRange(query[1], colors.size) - (query[1] - 1) * count.sumRange(query[1], colors.size))
            else if (colors[query[1]] != query[2]) {
                colors[query[1]] = query[2]
                if (query[2] == colors[(query[1] - 1 + colors.size) % colors.size]) add((query[1] - 1 + colors.size) % colors.size, colors.size)
                else remove((query[1] - 1 + colors.size) % colors.size, colors.size)
                if (query[2] == colors[(query[1] + 1) % colors.size]) add(query[1], colors.size)
                else remove(query[1], colors.size)
            }
        return list
    }

    internal inner class Arr(sz: Int) {
        private val nums = IntArray(sz)
        private val tree = IntArray(nums.size + 1)

        init {
            for (i in nums.indices) add(i + 1, nums[i])
        }

        fun update(index: Int, v: Int) {
            add(index + 1, v)
            nums[index] = v
        }

        fun sumRange(left: Int, right: Int): Int = prefixSum(right + 1) - prefixSum(left)

        private fun lowBit(x: Int): Int = x and -x

        private fun add(i: Int, v: Int) {
            var i = i
            while (i < tree.size) {
                tree[i] += v
                i += lowBit(i)
            }
        }

        private fun prefixSum(i: Int): Int {
            var i = i
            var sum = 0
            while (i > 0) {
                sum += tree[i]
                i -= lowBit(i)
            }
            return sum
        }
    }

}