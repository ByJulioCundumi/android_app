package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));

        TextView ageValue = (TextView) findViewById(R.id.main_ageId);
        TextView itemsMessage = (TextView) findViewById(R.id.main_messageId);
        TextView userCounter = (TextView) findViewById(R.id.main_counterId);

        //
        userCounter.setText(String.valueOf(UserList.getUserCount()));
        ageValue.setText(String.valueOf(UserList.getAverageAge()));
        //
        RecyclerView rcv = (RecyclerView) findViewById(R.id.main_recyclerViewId);
        //
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rcv.setLayoutManager(llm);
        //
        List<User> userList = UserList.getUserList();
        if (userList.isEmpty()) {
            // La lista de usuarios es nula
            itemsMessage.setText("Aún no hay usuarios registrados. Precione el boton \n \n -> NUEVO USUARIO <-");
        } else {
            UserAdapter userAdapter = new UserAdapter(userList);
            rcv.setAdapter(userAdapter);
        }
    }

    public void mainToInsert(View view){
        Intent i = new Intent(this, InsertUserActivity.class);
        startActivity(i);
    }

    public void mainToStatistics(View view){
        Intent i = new Intent(this, StatisticsActivity.class);
        startActivity(i);
    }
}