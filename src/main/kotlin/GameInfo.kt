package org.example

import com.google.gson.annotations.SerializedName

class GameInfo(
    @SerializedName("info") val info:InfoApiShark
) {
    override fun toString(): String {
        return info.toString()
    }
}