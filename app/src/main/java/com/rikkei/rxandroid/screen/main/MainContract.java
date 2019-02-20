package com.rikkei.rxandroid.screen.main;

import com.rikkei.rxandroid.data.model.User;

import java.util.List;

public interface MainContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showUsers(List<User> users);
        void showErorr(String error);
    }

    interface Presenter {
        void getUsers();
    }
}
