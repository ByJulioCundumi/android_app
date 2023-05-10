package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apppersonasucn.util.UserList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userCounter = (TextView) findViewById(R.id.main_counterId);
        userCounter.setText(String.valueOf(UserList.getUserCount()));
    }

    public void mainToInsert(View view){
        Intent i = new Intent(this, InsertUserActivity.class);
        startActivity(i);
    }
}