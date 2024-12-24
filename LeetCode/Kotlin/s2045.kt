class Solution2045 {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
        val minSteps = IntArray(n+1) {10_001}
        val al = edges.fold(Array(n){ mutableListOf<Int>() }) { a, e ->
            a[e[0]].add(e[1])
            a[e[1]].add(e[0])
        a}

        fun stepsTime(steps: Int): Int {
            var res = 0
            repeat(steps-1) {
                res += time
                if ( (res/change)%2 != 0) res = (res/change+1)*change
            }
            return res+time
        }

        var step = 0
        var q = mutableListOf(1)
        while (q.isNotEmpty() && step <= minSteps[n]+1) {
            var q1 = mutableListOf<Int>()
            q.forEach { i ->
                if (step!=minSteps[i] && step <= minSteps[i]+1) {
                    minSteps[i] = minOf(step, minSteps[i])
                    if (i==n && step > minSteps[n]) return stepsTime(step)
                    al[i].forEach { q1.add(it) }
                }
            }
            step++
            q = q1.also{q1=q}
        }
        return stepsTime(minSteps[n]+2)
    }

}
