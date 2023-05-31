package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.entity.UserLogin;
import com.example.apppersonasucn.util.UserList;
import com.example.apppersonasucn.util.UserListLogin;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText verifyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        //
        email = (EditText) findViewById(R.id.registerEmailId);
        password = (EditText) findViewById(R.id.registerPasswordId);
        verifyPassword = (EditText) findViewById(R.id.registerVerifyPasswordId);
    }

    public void registerToLogin(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void saveUser(View view){

        String value_email = email.getText().toString();
        String value_password = password.getText().toString();
        String value_verityPassword = verifyPassword.getText().toString();

        if( value_email.length() == 0 || value_email.isEmpty() ){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese un email", Toast.LENGTH_SHORT).show();
        } else if(value_password.length() == 0 || value_password.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese una contraseña", Toast.LENGTH_SHORT).show();
        } else if(value_verityPassword.length() == 0 || value_verityPassword.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, verifique su contraseña", Toast.LENGTH_SHORT).show();
        } else {
            if(value_password.equals(value_verityPassword)){
                UserLogin user = new UserLogin(value_email, value_verityPassword);
                UserListLogin.addUser(user);
                //
                Toast.makeText(this,"Se registro exitosamente :)", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
            }  else{
                Toast.makeText(this, "Las contraseñas ingresadas no coinciden :(", Toast.LENGTH_SHORT).show();
            }
        }
    }
}