import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.forEach
import kotlin.collections.listOf

class Solution1203 {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        var idx = m
        val groupItems = Array(n+m){ mutableListOf<Int>() }
        val itemDegree = IntArray(n)
        val groupDegree = IntArray(n + m)
        val itemGraph = Array(n) { mutableListOf<Int>() }
        val groupGraph = Array(n+m) { mutableListOf<Int>() }

        (0..<n).forEach { i ->
            if (group[i] == -1) group[i] = idx++
            groupItems[group[i]].add(i)
        }
        for (i in 0..<n)
            for (j in beforeItems[i])
                if (group[i] == group[j]) {
                    itemDegree[i]++
                    itemGraph[j].add(i)
                } else {
                    groupDegree[group[i]]++
                    groupGraph[group[j]].add(group[i])
                }

        var items = mutableListOf<Int>()
        (0..<n + m).forEach { items.add(it) }
        val groupOrder = topoSort(groupDegree, groupGraph, items)
        if (groupOrder.isEmpty()) return intArrayOf()

        val res = mutableListOf<Int>()
        for (o in groupOrder) {
            items = groupItems[o]
            val itemOrder = topoSort(itemDegree, itemGraph, items)
            if (itemOrder.size != items.size) return intArrayOf()
            res.addAll(itemOrder)
        }
        return res.toIntArray()
    }

    private fun topoSort(degree: IntArray, graph: Array<MutableList<Int>>, items: List<Int>): List<Int> {
        val q = mutableListOf<Int>()
        (items).forEach { if (degree[it] == 0) q.add(it) }
        val res = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            res.add(i)
            graph[i].forEach { if (--degree[it] == 0) q.add(it) }
        }
        return if (res.size == items.size) res else listOf()
    }
}
