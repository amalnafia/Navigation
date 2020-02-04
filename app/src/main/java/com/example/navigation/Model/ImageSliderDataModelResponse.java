package com.example.navigation.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageSliderDataModelResponse {

    @SerializedName("MediaPromotionImage")
    private String MediaPromotionImage;

    public String getMediaPromotionImage() {
        return MediaPromotionImage;
    }
}
