class Solution1236 {
    fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
        val res = mutableSetOf<String>()

        fun dfs(url: String, htmlParser: HtmlParser) {
            if (res.contains(url)) return
            res.add(url)
            for (next in htmlParser.getUrls(url))
                if (host(next) == host(url)) dfs(next, htmlParser)
        }

        dfs(startUrl, htmlParser)
        return res.toList()
    }

    private fun host(url: String): String =
        url.substring(7).split("/").dropLastWhile { it.isEmpty() }.first()

}

abstract class HtmlParser {
    abstract fun getUrls(url: String): List<String>
}