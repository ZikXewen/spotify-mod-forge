package zikxewen.spotify.utils

import java.util.concurrent.Executors

object Async {
    private val executor = Executors.newCachedThreadPool()
    fun async(task: Runnable) = executor.execute(task)
}