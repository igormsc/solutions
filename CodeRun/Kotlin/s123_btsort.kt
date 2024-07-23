import java.io.BufferedReader
import java.io.InputStreamReader

// 123. Обход

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val nums = reader.readLine().trim().split(' ').map(String::toLong).dropLast(1).toSet()

    var root: Node? = null
    nums.forEach{ root = insert(root, it) }
    inorder(root)
}

class Node(var key: Long) {
    var left: Node? = null
    var right: Node? = null
}

fun insert(root: Node?, key: Long): Node {
    if (root == null) return Node(key)
    if (key < root.key) root.left = insert(root.left, key)
    else root.right = insert(root.right, key)
    return root
}

fun inorder(root: Node?) {
    if (root != null) {
        inorder(root.left)
        println(root.key)
        inorder(root.right)
    }
}
