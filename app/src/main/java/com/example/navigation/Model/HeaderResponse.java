package com.example.navigation.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeaderResponse<T> {

    @SerializedName("data")
    private T data;
    @SerializedName("resultmessagear")
    private String resultmessagear;
    @SerializedName("resultmessageen")
    private String resultmessageen;
    @SerializedName("resultcode")
    private int resultcode;

    public T getData() {
        return data;
    }

    public String getResultmessagear() {
        return resultmessagear;
    }

    public String getResultmessageen() {
        return resultmessageen;
    }

    public int getResultcode() {
        return resultcode;
    }
}
