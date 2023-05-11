package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

public class InsertUserActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText email;
    private EditText password;
    private TextView userCounter;
    private TextView averageAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        firstName = (EditText) findViewById(R.id.insert_firstNameId);
        lastName = (EditText) findViewById(R.id.insert_lastNameId);
        age = (EditText) findViewById(R.id.insert_ageId);
        email = (EditText) findViewById(R.id.insert_emailId);
        password = (EditText) findViewById(R.id.insert_passwordId);
        //
        userCounter = (TextView) findViewById(R.id.insert_userCounterId);
        averageAge = (TextView) findViewById(R.id.insert_averageAgeId);
        //
        userCounter.setText(String.valueOf(UserList.getUserCount()));
        averageAge.setText(String.valueOf(UserList.getAverageAge()));
    }

    public void insertToMain(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void saveUser(View view){

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
                User user = new User();

                user.setFirstName(value_firstName);
                user.setLastName(value_lastName);
                user.setAge(value_age);
                user.setEmail(value_email);
                user.setPassword(value_password);

                UserList.addUser(user);
                Toast.makeText(this, "Se registró un nuevo usuario exitosamente :)", Toast.LENGTH_SHORT).show();
                userCounter.setText(String.valueOf(UserList.getUserCount()));
                averageAge.setText(String.valueOf(UserList.getAverageAge()));
            }
        }
    }


}