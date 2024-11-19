package com.krsone9.superheroes.data

import android.media.Image
import com.google.gson.annotations.SerializedName
import java.net.URL

data class SuperheroesResponse(
    @SerializedName("response") val response : String,
    @SerializedName("results-for") val resultsFor : String,
    @SerializedName("results") val results : List<SuperheroeResponse>

)

data class SuperheroeResponse (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    //@SerializedName("powerstats") val powerstats : String,
   // @SerializedName("image") val image: Image

)

/*data class Image (
    @SerializedName("url") val url: String

)*/