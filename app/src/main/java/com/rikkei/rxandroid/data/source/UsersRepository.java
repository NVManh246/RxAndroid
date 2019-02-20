package com.rikkei.rxandroid.data.source;

import com.rikkei.rxandroid.data.model.User;
import com.rikkei.rxandroid.data.source.remote.UsersRemoteDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class UsersRepository implements UsersDataSource.UsersRemoteDataSource {

    private static UsersRepository sInstance;
    private UsersDataSource.UsersRemoteDataSource mUsersRemoteDataSource;

    public UsersRepository(UsersRemoteDataSource usersRemoteDataSource) {
        mUsersRemoteDataSource = usersRemoteDataSource;
    }

    public static UsersRepository getInstance(UsersRemoteDataSource usersRemoteDataSource) {
        if(sInstance == null) {
            sInstance = new UsersRepository(usersRemoteDataSource);
        }
        return sInstance;
    }

    @Override
    public Flowable<List<User>> getUsers() {
        return mUsersRemoteDataSource.getUsers();
    }
}
