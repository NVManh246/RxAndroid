package com.rikkei.rxandroid.data.retrofit;

import com.rikkei.rxandroid.data.model.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface UserInterface {
    @GET("users")
    Flowable<List<User>> getUser();
}
