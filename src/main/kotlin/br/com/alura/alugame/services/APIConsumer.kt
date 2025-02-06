package br.com.alura.alugame.services

import br.com.alura.alugame.model.Game
import com.google.gson.Gson
import br.com.alura.alugame.model.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class APIConsumer {

    fun searchGame(id:String): Game? {
        val URIAddress = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(URIAddress))
            .build()
        val response =
            client.send(request, BodyHandlers.ofString())

        val json = response.body()
        println(json)

        val gson = Gson()

        var myGame: Game? = null

        val result = runCatching {
            val myGameInfo = gson.fromJson(json, GameInfo::class.java)

            myGame = Game(
                myGameInfo.info.title,
                myGameInfo.info.thumb)

        }

        result.onFailure {
            println("Jogo inexistente. Tente outro id.")
            return null
        }

        return myGame
    }
}