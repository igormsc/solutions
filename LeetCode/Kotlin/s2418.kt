class Solution2418 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val a = names.foldIndexed(mutableListOf<Person>()) { i, r, s -> r.add(Person(s, heights[i])); r}
        a.sortWith(compareBy { -it.height })
        return a.map{it.name}.toTypedArray()
    }
    data class Person(val name: String, val height: Int)

}
