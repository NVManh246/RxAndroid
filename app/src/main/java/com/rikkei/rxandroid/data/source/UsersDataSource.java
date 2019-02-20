package com.rikkei.rxandroid.data.source;

import com.rikkei.rxandroid.data.model.User;

import java.util.List;

import io.reactivex.Flowable;

public interface UsersDataSource {
    interface UsersRemoteDataSource {
        Flowable<List<User>> getUsers();
    }
}
