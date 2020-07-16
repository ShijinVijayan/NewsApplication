package app.shijin.shijinnewsapp.util;

import app.shijin.shijinnewsapp.model.NewsArticles;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIResponse {

    @GET("top-headlines")
    Call<NewsArticles> getTopHeadlines(@Query("country") String country,
                                       @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsArticles> getWorldHeadlines(@Query("sources") String sources,
                                         @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsArticles> getCategoryOfHeadlines(@Query("country") String country,
                                              @Query("category") String category,
                                              @Query("apiKey") String apiKey);
}
