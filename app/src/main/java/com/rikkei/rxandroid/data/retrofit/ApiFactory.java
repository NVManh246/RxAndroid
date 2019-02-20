package com.rikkei.rxandroid.data.retrofit;

public class ApiFactory {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static UserInterface getApi() {
        return ApiConfig.getRetrofit(BASE_URL).create(UserInterface.class);
    }
}
