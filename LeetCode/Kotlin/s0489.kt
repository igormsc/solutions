class Solution489 {

    fun cleanRoom(robot: Robot) {
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        val vis = mutableSetOf<List<Int>>()

        fun dfs(i: Int, j: Int, d: Int) {
            robot.clean()
            vis.add(listOf(i, j))
            (0..3).forEach { k ->
                val nd = (d + k) % 4
                val (x, y) = (i + dirs[nd]) to  (j + dirs[nd + 1])
                if (!vis.contains(listOf(x, y)) && robot.move()) {
                    dfs(x, y, nd)
                    robot.turnRight()
                    robot.turnRight()
                    robot.move()
                    robot.turnRight()
                    robot.turnRight()
                }
                robot.turnRight()
            }
        }

        dfs(0, 0, 0)
    }
}

abstract class Robot() {
    abstract fun turnRight()
    abstract fun move():Boolean
    abstract fun clean()

}
