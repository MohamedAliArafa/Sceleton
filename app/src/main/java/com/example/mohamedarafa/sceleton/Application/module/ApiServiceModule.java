package com.example.mohamedarafa.sceleton.Application.module;

import com.example.mohamedarafa.sceleton.Application.scope.ApplicationScope;
import com.example.mohamedarafa.sceleton.service.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohamed.arafa on 8/27/2017.
 */

@Module(includes = NetworkModule.class)
public class ApiServiceModule {

    @Provides
    @ApplicationScope
    public ApiService apiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("http://108.179.204.213:8093/api/")
                .build();
    }

    @Provides
    @ApplicationScope
    public Gson gson(){
        return new GsonBuilder().create();
    }
}
