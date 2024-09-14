class Solution3273 {
    fun minDamage(power: Int, damage: IntArray, health: IntArray): Long {
        val nums = Array(damage.size) {it}
        nums.sortWith{ i, j -> (health[i] + power - 1)/power * damage[j] - (health[j] + power - 1)/ power * damage[i] }
        var t = 0L
        return nums.fold(0L) { r, i ->
            t += ((health[i] + power -1)/ power).toLong()
            r + damage[i] * t
        }
    }
}
