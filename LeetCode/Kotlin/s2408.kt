class SQL(names: List<String>, columns: List<Int>) {

    private val tables = mutableMapOf<String, MutableList<List<String>>>()

    fun insertRow(name: String, row: List<String>) {
        tables.computeIfAbsent(name){ mutableListOf() }.add(row)
    }

    fun deleteRow(name: String?, rowId: Int) {
    }

    fun selectCell(name: String, rowId: Int, columnId: Int): String =
        tables[name]!![rowId - 1][columnId - 1]

}