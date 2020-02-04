package com.example.navigation.Model;

import com.google.gson.annotations.SerializedName;

public class HomeSliderDataRequest {

    @SerializedName("CategoryId")
    private int CategoryId;

    @SerializedName("CountryId")
    private int CountryId;

    public HomeSliderDataRequest(int categoryId, int countryId) {
        CategoryId = categoryId;
        CountryId = countryId;
    }
}
