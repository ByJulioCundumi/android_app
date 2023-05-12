package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

import java.util.Objects;

public class UpdateUserActivity extends AppCompatActivity {


    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText email;
    private EditText password;
    private TextView userCounter;
    private TextView averageAge;
    private User actualUser;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        //
        firstName = (EditText) findViewById(R.id.update_firstNameId);
        lastName = (EditText) findViewById(R.id.update_lastNameId);
        age = (EditText) findViewById(R.id.update_ageId);
        email = (EditText) findViewById(R.id.update_emailId);
        password = (EditText) findViewById(R.id.update_passwordId);
        userCounter = (TextView) findViewById(R.id.update_userCounterId);
        averageAge = (TextView) findViewById(R.id.update_userAverageAgeId);
        //
        userCounter.setText(String.valueOf(UserList.getUserCount()));
        averageAge.setText(String.valueOf(UserList.getAverageAge()));
        //
        Intent dataIntent = getIntent();
        if (dataIntent.hasExtra("userData")) {
            this.actualUser = (User) dataIntent.getSerializableExtra("userData");
            firstName.setText(actualUser.getFirstName());
            lastName.setText(actualUser.getLastName());
            age.setText(String.valueOf(actualUser.getAge()));
            email.setText(actualUser.getEmail());
            password.setText(actualUser.getPassword());
            position = (int) dataIntent.getSerializableExtra("position");
        }
        else {
            Toast.makeText(this, "Hubo un error y no llegaron los datos :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateBtn(View view){
        String value_firstName = firstName.getText().toString();
        String value_lastName = lastName.getText().toString();
        String value_age_str = age.getText().toString();
        String value_email = email.getText().toString();
        String value_password = password.getText().toString();

        if( value_firstName.length() == 0 || value_firstName.isEmpty() ){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese un nombre", Toast.LENGTH_SHORT).show();
        } else if(value_lastName.length() == 0 || value_lastName.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese un apellido", Toast.LENGTH_SHORT).show();
        } else if(TextUtils.isEmpty(value_age_str)){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese una edad", Toast.LENGTH_SHORT).show();
        } else if(value_email.length() == 0 || value_email.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese un email", Toast.LENGTH_SHORT).show();
        } else if(value_password.length() == 0 || value_password.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese una contraseña", Toast.LENGTH_SHORT).show();
        }
        else {
            int value_age = Integer.parseInt(value_age_str);
            if(value_age <= 0){
                Toast.makeText(this,"Ingrese una edad valida", Toast.LENGTH_SHORT).show();
            }  else{
                User updateUser = new User();
                updateUser.setFirstName(value_firstName);
                updateUser.setLastName(value_lastName);
                updateUser.setAge(value_age);
                updateUser.setEmail(value_email);
                updateUser.setPassword(value_password);
                UserList.updateUser(this.position, updateUser);

                    Toast.makeText(this, "Se Actualizaron los datos Correctamente :)", Toast.LENGTH_SHORT).show();
                    userCounter.setText(String.valueOf(UserList.getUserCount()));
                    averageAge.setText(String.valueOf(UserList.getAverageAge()));
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
            }
        }
    }

    public void updateToMain(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}