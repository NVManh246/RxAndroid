package com.rikkei.rxandroid.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.rikkei.rxandroid.R;
import com.rikkei.rxandroid.data.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerUser;
    private UserAdapter mUserAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerUser = findViewById(R.id.recycler_user);
        mProgressBar = findViewById(R.id.progress);
        mUserAdapter = new UserAdapter();
        mRecyclerUser.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerUser.setAdapter(mUserAdapter);
        mPresenter = new MainPresenter(this);
        mPresenter.getUsers();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsers(List<User> users) {
        mUserAdapter.setData(users);
    }

    @Override
    public void showErorr(String error) {
        System.out.println(error);
    }
}
