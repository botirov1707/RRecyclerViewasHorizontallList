package com.example.recyclerviewinsiderecycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecycleview.Model.User;
import com.example.recyclerviewinsiderecycleview.Model.UserSub;
import com.example.recyclerviewinsiderecycleview.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST =1;

    private Context context;
    private List<User> userList;

    public CustomAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getItemViewType(int position) {
        if (userList.get(position).getUserSubs() != null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == TYPE_ITEM_LIST){
           View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_recycle,viewGroup,false);
           return  new CustomListHolder(header);
       }

       View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view,viewGroup,false);
       return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = userList.get(position);
        if (holder instanceof CustomViewHolder ){

        }

        if (holder instanceof CustomListHolder){
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));
            refreshAdapter(recyclerView,user.getUserSubs());

        }

    }

    private void refreshAdapter(RecyclerView recyclerView, List<UserSub> userSubList) {
        CustomSubAdapter adapter = new CustomSubAdapter(context, userSubList);
        recyclerView.setAdapter(adapter);
    }

    public class CustomViewHolder  extends RecyclerView.ViewHolder{
        public View view;

        public CustomViewHolder(View v){
            super(v);
            view = v;
        }
    }

    public class CustomListHolder extends RecyclerView.ViewHolder{
        public View view;
        public RecyclerView recyclerView;

        public CustomListHolder(View v){
            super(v);
            view = v;
            recyclerView = view.findViewById(R.id.view_recycle_id);
        }
    }
}
