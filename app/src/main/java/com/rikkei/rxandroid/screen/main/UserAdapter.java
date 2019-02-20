package com.rikkei.rxandroid.screen.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rikkei.rxandroid.R;
import com.rikkei.rxandroid.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(mUsers.get(i));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void setData(List<User> users) {
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextUsername;
        private TextView mTextEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextUsername = itemView.findViewById(R.id.text_username);
            mTextEmail = itemView.findViewById(R.id.text_email);
        }

        private void bindView(User user) {
            mTextEmail.setText(user.getEmail());
            mTextUsername.setText(user.getUsername());
        }
    }
}
