package com.example.navigation.Model;

import java.util.List;

public class CommonObject {
    private List<CategoryDataModelResponse> CategoryList;
    private List<String> ImageList;

    public List<CategoryDataModelResponse> getCategoryList() {
        return CategoryList;
    }

    public List<String> getImageList() {
        return ImageList;
    }

    public CommonObject(List<CategoryDataModelResponse> categoryList, List<String> imageList) {
        CategoryList = categoryList;
        ImageList = imageList;
    }
}
