package com.rikkei.rxandroid.data.source.remote;

import com.rikkei.rxandroid.data.model.User;
import com.rikkei.rxandroid.data.retrofit.UserInterface;
import com.rikkei.rxandroid.data.source.UsersDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class UsersRemoteDataSource implements UsersDataSource.UsersRemoteDataSource {

    private static UsersRemoteDataSource sInstance;
    private UserInterface mUserInterface;

    private UsersRemoteDataSource(UserInterface userInterface) {
        mUserInterface = userInterface;
    }

    public static UsersRemoteDataSource getInstance(UserInterface userInterface) {
        if(sInstance == null) {
            sInstance = new UsersRemoteDataSource(userInterface);
        }
        return sInstance;
    }

    @Override
    public Flowable<List<User>> getUsers() {
        return mUserInterface.getUser();
    }
}
