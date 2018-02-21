package neoncore.com.lablae.api;

import java.util.ArrayList;

import neoncore.com.lablae.api.models.PhotoObjects;
import neoncore.com.lablae.api.models.PhotoResp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Musa on 1/5/2018.
 */

public interface UnsplashService {


    @GET("photos")
    Call<ArrayList<PhotoObjects>> getPhotosListInitial(@Query("page")int page,@Query("per_page")int perPage);

    @GET("photos")
    Call< ArrayList<PhotoObjects>>getPhotosListAfter( @Query("per_page")int perPage, @Query("page") int page);
}
