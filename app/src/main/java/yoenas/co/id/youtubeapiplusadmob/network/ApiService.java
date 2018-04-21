package yoenas.co.id.youtubeapiplusadmob.network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yoenas.co.id.youtubeapiplusadmob.responseServer.ResponseYoutube;

public interface ApiService {
//  part=snippet&maxResults=25&q=surfing&regionCode=ID&type=sport&key=AIzaSyB63m3JSWR6qXaL-mgMvyWbh_ktNRpjHBg
//  AIzaSyB63m3JSWR6qXaL-mgMvyWbh_ktNRpjHBg

    // Todo 3
    @GET("search")
    Call<ResponseYoutube> getVideo(@Query("part")String part,
                                   @Query("maxResults")String result,
                                   @Query("q")String keyword,
                                   @Query("regionCode")String regionCode,
                                   @Query("type")String type,
                                   @Query("key")String key);
}
