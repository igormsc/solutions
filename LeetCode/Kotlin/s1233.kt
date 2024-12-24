class Solution1233 {
    fun removeSubfolders(folder: Array<String>): List<String> {
        folder.sort()
        return folder.fold(mutableListOf()) { r, d -> if (r.isEmpty() || !d.startsWith("${r.last()}/")) r.add(d); r}
    }
}
