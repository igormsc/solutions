import java.util.*
import kotlin.Comparator

class TodoList() {

    private var i = 1
    private val tasks = mutableMapOf<Int, TreeSet<Task>>()

    fun addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List<String>?): Int {
        val task = Task(i++, taskDescription, dueDate, tags!!.toSet())
        tasks.computeIfAbsent(userId) { TreeSet(Comparator.comparingInt { a: Task -> a.dueDate }) }.add(task)
        return task.taskId
    }

    fun getAllTasks(userId: Int): List<String> {
        val res = mutableListOf<String>()
        if (tasks.containsKey(userId))
            for (task in tasks[userId]!!)
                if (!task.finish)
                    res.add(task.taskName)
        return res
    }

    fun getTasksForTag(userId: Int, tag: String): List<String> {
        val res = mutableListOf<String>()
        if (tasks.containsKey(userId))
            for (task in tasks[userId]!!)
                if (task.tags.contains(tag) && !task.finish)
                    res.add(task.taskName)
        return res
    }

    fun completeTask(userId: Int, taskId: Int) {
        if (tasks.containsKey(userId))
            for (task in tasks[userId]!!)
                if (task.taskId == taskId) {
                    task.finish = true
                    break
                }
    }

    internal class Task(var taskId: Int, var taskName: String, var dueDate: Int, var tags: Set<String>, var finish: Boolean = false)
}