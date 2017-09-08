package com.example.admin.moviedatabase.retrofit;

import com.example.admin.moviedatabase.model.DetailsMovie;
import com.example.admin.moviedatabase.model.SearchMovie;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 9/8/2017.
 */

public class RetrofitHelper {

    public static final String API_KEY = "e9d7463efbf0cb32be45a45d84a7b521";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String SEARCH_PATH = "search/movie?api_key=" + API_KEY;
    public static final String DETAILS_PATH = "movie/{movie_id}?api_key=" + API_KEY;



    public static Retrofit create(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<SearchMovie> callMovieList(String bookTitle) {

        Retrofit retrofit = create(BASE_URL);
        WeatherService weatherService = retrofit.create(WeatherService.class);

        return weatherService.getMovieList(bookTitle);
    }

    public static Call<DetailsMovie> callMovieDetails(String movieId) {

        Retrofit retrofit = create(BASE_URL);
        WeatherService weatherService = retrofit.create(WeatherService.class);

        return weatherService.getMovieDetails(movieId);
    }


    public interface WeatherService {

        @GET(SEARCH_PATH)
        Call<SearchMovie> getMovieList(@Query("query") String bookTitle);

        @GET(DETAILS_PATH)
        Call<DetailsMovie> getMovieDetails(@Path("movie_id") String movieID);

    }

}
