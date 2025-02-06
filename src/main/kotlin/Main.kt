package org.example

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val readiness = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val search = readiness.nextLine()

    val URIAddress = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(URIAddress))
        .build()
    val response =
        client.send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()

    var myGame:Game? = null

    val result = runCatching {
        val myGameInfo = gson.fromJson(json, GameInfo::class.java)

        myGame = Game(
            myGameInfo.info.title,
            myGameInfo.info.thumb)

        println(myGame)
    }

    result.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val option = readiness.nextLine()
        if (option.equals("S", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val customDescription = readiness.nextLine()
            myGame?.description = customDescription
        } else {
            myGame?.description = myGame?.title
        }

        println(myGame)
    }

    result.onSuccess {
        println("Busca finalizada com sucesso")
    }
}