package com.example.recyclerviewinsiderecycleview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewinsiderecycleview.Model.User;
import com.example.recyclerviewinsiderecycleview.Model.UserSub;
import com.example.recyclerviewinsiderecycleview.R;
import com.example.recyclerviewinsiderecycleview.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
//        List<User> userList = prepareMemerList();
        refreshAdapter(prepareMemerList());
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private void refreshAdapter(List<User> userList){
        CustomAdapter adapter = new CustomAdapter(context,userList);
        recyclerView.setAdapter(adapter);
    }
    private  List<User> prepareMemerList(){
        List<User> userList = new ArrayList<>();
//        userList.add(new User());
        for (int i = 0; i < 30; i++) {
            if (i==5||i==11){
                userList.add(new User("Botirov "+i,"Bekhruzbek "+i,prepareSubUsers()));
            }else {
                userList.add(new User("Bekh"+i,"Bbb"+i,null));
            }
            
        }
//        userList.add(new  User());
        return userList;
    }

    private List<UserSub> prepareSubUsers(){
        List<UserSub> userSubList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userSubList.add(new UserSub());
        }
        return userSubList;
    }
}