package app.shijin.shijinnewsapp.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static app.shijin.shijinnewsapp.model.Constants.BASE_URL;

public class APIClientSIde {
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static APIResponse getApiService() {
        return getRetrofitInstance().create(APIResponse.class);
    }
}
