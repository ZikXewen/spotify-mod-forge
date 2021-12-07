package zikxewen.spotify.auth

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.logging.log4j.Level
import zikxewen.spotify.SpotifyMod
import zikxewen.spotify.config.Config
import zikxewen.spotify.utils.Request
import zikxewen.spotify.utils.SpotifyControls
import zikxewen.spotify.utils.TokenResponseClass
import java.net.InetSocketAddress
import java.nio.charset.Charset

object AuthServer {
    private var refreshToken = Config.refreshToken.get()
    private var code = ""
    fun register() {
        val authServer = HttpServer.create(InetSocketAddress(5000), 0)
        authServer.createContext("/callback", ::handle)
        authServer.start()
        SpotifyMod.logger.log(Level.INFO, "Started")
        if(refreshToken != "") refresh()
    }
    private fun refresh() {
        val response = Request.get(SpotifyMod.ENDPOINT + "getToken?refreshToken=$refreshToken", TokenResponseClass::class)
        if(response != null && response.accessToken.isNotEmpty()) {
            SpotifyControls.accessToken = response.accessToken
            SpotifyMod.logger.log(Level.INFO, "Refreshed Token.")
        } else {
            SpotifyMod.logger.log(Level.WARN, "Refreshing Failed")
        }
    }
    private fun login(): Boolean {
        val response = Request.get(SpotifyMod.ENDPOINT + "getToken?code=$code", TokenResponseClass::class) ?: return false
        SpotifyControls.accessToken = response.accessToken
        refreshToken = response.refreshToken
        Config.refreshToken.set(refreshToken)
        return true
    }
    private fun handle(exchange: HttpExchange) {
        if(exchange.requestMethod.equals("GET")) {
            val params = URLEncodedUtils.parse(exchange.requestURI.query, Charset.forName("UTF-8"))
            params.forEach { if(it.name.equals("code")) code = it.value }
            val response = if(code.isNotEmpty() && login()) "Login Success. You can go back to Minecraft now." else "Login Failed"
            SpotifyMod.logger.log(Level.INFO, response)
            exchange.sendResponseHeaders(200, response.length.toLong())
            val os = exchange.responseBody
            os.write(response.toByteArray())
            os.close()
        }
    }
}