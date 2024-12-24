import java.util.*

class VideoSharingPlatform() {

    fun upload(video: String): Int {
        val id = nextId()
        val v = Video(video)
        return if (id == -1) {
            data.add(v)
            data.lastIndex
        } else {
            data[id] = v
            id
        }
    }

    fun remove(videoId: Int) {
        if (videoId < data.size) {
            data[videoId].clr()
            unusedIds.offer(videoId)
        }
    }

    fun watch(videoId: Int, startMinute: Int, endMinute: Int): String = if (videoId >= data.size) "-1" else {
        val v = data[videoId]
        if (v.uuid.isEmpty() || v.uuid.length < startMinute) "-1"
        else {
            v.view++
            v.uuid.substring(startMinute, minOf(v.uuid.lastIndex, endMinute) + 1)
        }
    }

    fun like(videoId: Int) {
        if (videoId < data.size && data[videoId].uuid.isNotEmpty()) data[videoId].like++
    }

    fun dislike(videoId: Int) {
        if (videoId < data.size && data[videoId].uuid.isNotEmpty()) data[videoId].dislike++
    }

    fun getLikesAndDislikes(videoId: Int): IntArray =
        if (videoId < data.size && data[videoId].uuid.isNotEmpty()) intArrayOf(data[videoId].like, data[videoId].dislike) else intArrayOf(-1)

    fun getViews(videoId: Int): Int =
        if (videoId < data.size && data[videoId].uuid.isNotEmpty()) data[videoId].view else -1

    private fun nextId() = if (unusedIds.isEmpty()) -1 else unusedIds.poll()
    private var data = mutableListOf<Video>()
    private var unusedIds: PriorityQueue<Int> = PriorityQueue()

    class Video(var uuid: String, var view: Int = 0, var like: Int = 0, var dislike: Int = 0) {
        fun clr() { uuid = ""; view = 0; like = 0; dislike = 0 }
    }

}
