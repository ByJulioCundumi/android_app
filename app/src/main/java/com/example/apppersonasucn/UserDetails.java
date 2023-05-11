package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

import java.util.Objects;

public class UserDetails extends AppCompatActivity {
    private TextView firstName;
    private TextView lastName;
    private TextView age;
    private TextView email;
    private TextView password;
    private TextView userCounter;
    private TextView averageAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        //
        firstName = (TextView) findViewById(R.id.user_details_firstnameId);
        lastName = (TextView) findViewById(R.id.user_details_lastnameId);
        age = (TextView) findViewById(R.id.user_details_ageId);
        email = (TextView) findViewById(R.id.user_details_emailId);
        password = (TextView) findViewById(R.id.user_details_passwordId);
        userCounter = (TextView) findViewById(R.id.user_details_counterId);
        averageAge = (TextView) findViewById(R.id.user_details_averageAgeId);
        //
        userCounter.setText(String.valueOf(UserList.getUserCount()));
        averageAge.setText(String.valueOf(UserList.getAverageAge()));
        //
        Intent dataIntent = getIntent();
        if (dataIntent.hasExtra("userData")) {
            User user = (User) dataIntent.getSerializableExtra("userData");
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            age.setText(String.valueOf(user.getAge()));
            email.setText(user.getEmail());
            password.setText(user.getPassword());
        } else {
            Toast.makeText(this, "Hubo un error y no llegaron los datos :(", Toast.LENGTH_SHORT).show();
        }

    }

    public void userDetailsToMainActivity(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}