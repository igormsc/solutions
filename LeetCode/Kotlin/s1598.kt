class Solution1598 {
    fun minOperations(logs: Array<String>): Int {
        var steps = 0
        logs.forEach { if (it == "../") { if (steps >= 1) steps-- } else if (it != "./") steps++ }
        return steps
    }
}
