package com.example.silveroctomoviebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silveroctomoviebase.API.APIInterface
import com.example.silveroctomoviebase.API.MovieAPI
import com.example.silveroctomoviebase.models.Movie
import com.example.silveroctomoviebase.models.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPopularMovies.layoutManager = LinearLayoutManager(this)
        rvPopularMovies.setHasFixedSize(true)
        getMovies { movies : List<Movie> -> rvPopularMovies.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovies(callback: (List<Movie>)->Unit){
        val apiService = MovieAPI.getInstance().create(APIInterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(
                call: retrofit2.Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: retrofit2.Call<MovieResponse>, t: Throwable) {

            }

        })
    }


}