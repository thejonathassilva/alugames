package br.com.alura.alugame.model

import com.google.gson.annotations.SerializedName

data class GameInfo(
    @SerializedName("info") val info: InfoApiShark
) {
    override fun toString(): String {
        return info.toString()
    }
}