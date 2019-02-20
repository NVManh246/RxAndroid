package com.rikkei.rxandroid.screen.main;

import com.rikkei.rxandroid.data.model.User;
import com.rikkei.rxandroid.data.retrofit.ApiFactory;
import com.rikkei.rxandroid.data.source.UsersRepository;
import com.rikkei.rxandroid.data.source.remote.UsersRemoteDataSource;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private UsersRepository mUsersRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mUsersRepository = UsersRepository
                .getInstance(UsersRemoteDataSource.getInstance(ApiFactory.getApi()));
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getUsers() {
        mView.showProgress();
        Disposable disposable = mUsersRepository.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) {
                        mView.hideProgress();
                        mView.showUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.showErorr(throwable.toString());
                        mView.hideProgress();
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
