class Solution796 {
    fun rotateString(s: String, goal: String): Boolean = s.length == goal.length && "$s$s".contains(goal)
}
