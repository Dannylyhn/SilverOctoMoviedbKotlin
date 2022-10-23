package com.example.silveroctomoviebase.API

import com.example.silveroctomoviebase.models.Movie
import com.example.silveroctomoviebase.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIInterface {
    @GET("/3/movie/popular?api_key=0a62ad33bf1055feb628ea894759e93b")
    fun getMovieList():Call<MovieResponse>

    @GET("movie/{movie_id}"+"?api_key=0a62ad33bf1055feb628ea894759e93b")
    fun getMovieDetails(@Path("movie_id") id: Int) : Call<Movie>
}


