package br.com.alura.alugame.main

import br.com.alura.alugame.services.APIConsumer
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val readiness = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val search = readiness.nextLine()

    val searchGameAPI = APIConsumer()
    val infoGame = searchGameAPI.searchGame(search)

    if (infoGame != null) {
        println("Deseja inserir uma descrição personalizada? S/N")
        val option = readiness.nextLine()
        if (option.equals("S", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val customDescription = readiness.nextLine()
            infoGame.description = customDescription
        } else {
            infoGame.description = infoGame.title
        }

        println(infoGame)
    }

    println("Busca finalizada com sucesso")
}