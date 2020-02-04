package com.example.navigation.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryDataModelResponse {
    @Expose
    @SerializedName("CategoryImageLoad")
    private String CategoryImageLoad;
    @Expose
    @SerializedName("CategoryImageOriginal")
    private String CategoryImageOriginal;
    @Expose
    @SerializedName("CategoryNameAr")
    private String CategoryNameAr;
    @Expose
    @SerializedName("CategoryNameEn")
    private String CategoryNameEn;
    @Expose
    @SerializedName("CategoryId")
    private int CategoryId;

    public String getCategoryImageLoad() {
        return CategoryImageLoad;
    }

    public String getCategoryImageOriginal() {
        return CategoryImageOriginal;
    }

    public String getCategoryNameAr() {
        return CategoryNameAr;
    }

    public String getCategoryNameEn() {
        return CategoryNameEn;
    }

    public int getCategoryId() {
        return CategoryId;
    }
}
