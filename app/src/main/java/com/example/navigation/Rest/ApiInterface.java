package com.example.navigation.Rest;

import com.example.navigation.Model.CategoryDataModelResponse;
import com.example.navigation.Model.HeaderRequest;
import com.example.navigation.Model.HeaderResponse;
import com.example.navigation.Model.ImageSliderDataModelResponse;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.Request;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("GetAllMediaPromotion/GetHomeSlider")
    Flowable<HeaderResponse<List<ImageSliderDataModelResponse>>> getImageSlider(@Body HeaderRequest request);

    @POST("SettingLists/GetCategory")
    Flowable<HeaderResponse<List<CategoryDataModelResponse>>> getCategory(@Body HeaderRequest request);

}
