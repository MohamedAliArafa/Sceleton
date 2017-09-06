package com.example.mohamedarafa.sceleton.service;

import com.example.mohamedarafa.sceleton.models.request.BaseRequestModel;
import com.example.mohamedarafa.sceleton.models.response.BaseResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mohamed.arafa on 8/27/2017.
 */

public interface ApiService {

    @POST("Sponsers/GetAllSponsers")
    Call<BaseResponseModel> getAllSponsors(@Body BaseRequestModel language);

}
