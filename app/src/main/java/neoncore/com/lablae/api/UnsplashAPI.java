package neoncore.com.lablae.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Musa on 1/6/2018.
 */

public class UnsplashAPI {

    public static UnsplashService createUnsplashService() {
    //THis is responsible for the random tests

      return ServiceGenerator.createService(UnsplashService.class);
    }
}
