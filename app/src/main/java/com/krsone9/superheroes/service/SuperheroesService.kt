package com.krsone9.superheroes.service

import com.krsone9.superheroes.data.SuperheroesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroesService {

    @GET("/api/4c9698ec0b392b6e780c5ba4910c03f1/search/{name}")
    suspend fun getSuperheroes(@Path("name")superheroeName: String): Response<SuperheroesResponse>


}