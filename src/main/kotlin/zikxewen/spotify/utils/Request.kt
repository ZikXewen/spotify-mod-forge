package zikxewen.spotify.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpPut
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import kotlin.reflect.KClass

object Request {
    private val httpClients = HttpClients.createDefault()
    private val format = Json {ignoreUnknownKeys = true}

    internal inline fun <reified T : Any> get(urlString: String, type: KClass<T>, headers: List<Pair<String, String>> = emptyList()): T?{
        val httpGet = HttpGet(urlString)
        headers.forEach{header -> httpGet.addHeader(header.first, header.second)}
        val response = httpClients.execute(httpGet)
        if(response.entity == null) return null
        val json = EntityUtils.toString(response.entity, "UTF-8")
        if(type == String::class) return json as T?
        return format.decodeFromString<T>(json)
    }
    fun req(method: String, urlString: String, headers: List<Pair<String, String>>): Int {
        val request = when (method) {
            "post" -> HttpPost(urlString)
            "put" -> HttpPut(urlString)
            else -> HttpGet(urlString)
        }
        headers.forEach{header -> request.addHeader(header.first, header.second)}
        val response = httpClients.execute(request)
        return response.statusLine.statusCode
    }
}