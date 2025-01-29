package org.example

data class Game(
    val title:String,
    val cover:String) {

    val description = ""

    override fun toString(): String {
        return "Game: \n" +
                "titulo = $title, \n" +
                "capa = $cover, \n" +
                "descrição = $description"
    }
}