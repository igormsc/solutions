class BrowserHistory(homepage: String) {
    private val history = mutableListOf(homepage)
    private val future = mutableListOf<String>()

    fun visit(url: String) {
        history.add(url)
        future.clear()
    }

    fun back(steps: Int): String {
        var steps = steps
        while (steps > 0 && history.size > 1) {
            future.add(history.removeLast())
            steps--
        }
        return history.last()
    }

    fun forward(steps: Int): String {
        var steps = steps
        while (steps > 0 && future.isNotEmpty()) {
            history.add(future.removeLast())
            steps--
        }
        return history.last()
    }

}
