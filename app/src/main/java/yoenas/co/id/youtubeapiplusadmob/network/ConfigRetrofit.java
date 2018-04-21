package yoenas.co.id.youtubeapiplusadmob.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yoenas.co.id.youtubeapiplusadmob.network.ApiService;

public class ConfigRetrofit {

    // Todo 1
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Todo 2 create Interface
    public static ApiService service = retrofit.create(ApiService.class);
}
