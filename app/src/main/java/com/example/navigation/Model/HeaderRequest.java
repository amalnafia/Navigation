package com.example.navigation.Model;

import com.google.gson.annotations.SerializedName;

public class HeaderRequest {

    @SerializedName("webServiceUser")
    private String webserviceUser;

    @SerializedName("data")
    private Object data;

    @SerializedName("deviceToken")
    private String deviceToken;

    @SerializedName("deviceType")
    private String deviceType;

    @SerializedName("notificationToken")
    private String notificationToken;

    @SerializedName("osVersion")
    private String osVersion;

    @SerializedName("userId")
    private int userId;

    @SerializedName("ApplicationTypeID")
    private String ApplicationTypeID;

    public HeaderRequest(String webserviceUser, Object data, String deviceToken,
                         String deviceType, String notificationToken, String osVersion,
                         int userId, String applicationTypeID) {
        this.webserviceUser = webserviceUser;
        this.data = data;
        this.deviceToken = deviceToken;
        this.deviceType = deviceType;
        this.notificationToken = notificationToken;
        this.osVersion = osVersion;
        this.userId = userId;
        ApplicationTypeID = applicationTypeID;
    }


}
