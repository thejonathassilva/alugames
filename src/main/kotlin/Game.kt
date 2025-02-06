package org.example

data class Game(
    val title:String,
    val cover:String) {

    var description:String? = null

    override fun toString(): String {
        return "Game: \n" +
                "titulo = $title, \n" +
                "capa = $cover, \n" +
                "descrição = $description"
    }
}