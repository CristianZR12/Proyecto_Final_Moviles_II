package edu.memento.thedogapi.retorfit

import retrofit2.http.GET

interface DogRetrofit {
    @GET("breeds")
    suspend fun getDogs():List<DogNetworkEntity>
}