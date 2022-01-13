package com.example.recyclerviewinsiderecycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecycleview.Model.User;
import com.example.recyclerviewinsiderecycleview.Model.UserSub;
import com.example.recyclerviewinsiderecycleview.R;

import java.util.ArrayList;
import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<UserSub> arrayList;

    public CustomSubAdapter(Context context, List<UserSub> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserSub user = arrayList.get(position);
        if (holder instanceof UserViewHolder){
            TextView textView = ((UserViewHolder) holder).textView;
            textView.setText(user.getStatus());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public UserViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tv_sub_name);
        }
    }
}
