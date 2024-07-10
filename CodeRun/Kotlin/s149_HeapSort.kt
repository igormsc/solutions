import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun <E: Comparable<E>> Array<E>.sortH() {
    val mid = size / 2 - 1
    (mid downTo 0).forEach { heapify(this, size, it) }
    (size - 1 downTo 0).forEach { i ->
        this[0] = this[i].also { this[i] = this[0] }
        heapify(this, i, 0)
    }
}

fun <E: Comparable<E>> heapify(arr: Array<E>, heapSize: Int, root: Int) {
    var largest = root
    val left = 2 * root + 1
    val right = 2 * root + 2
    if (left < heapSize && arr[left] > arr[largest]) largest = left
    if (right < heapSize && arr[right] > arr[largest]) largest = right

    if (largest != root) {
        arr[root] = arr[largest].also { arr[largest] = arr[root] }
        heapify(arr, heapSize, largest)
    }
}

fun main(args: Array<String>) {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val nums = reader.readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
    nums.sortH()
    reader.close()

    writer.write(nums.joinToString(" "))
    writer.newLine()
    writer.close()
}
