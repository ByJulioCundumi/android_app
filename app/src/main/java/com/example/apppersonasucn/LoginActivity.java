package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apppersonasucn.entity.UserLogin;
import com.example.apppersonasucn.util.UserListLogin;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        //
        email = (EditText) findViewById(R.id.loginEmailId);
        password = (EditText) findViewById(R.id.loginPasswordId);
    }

    public void loginToRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void loginBtn(View view){

        String value_email = email.getText().toString();
        String value_password = password.getText().toString();
        //
        if( value_email.length() == 0 || value_email.isEmpty() ){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese un email", Toast.LENGTH_SHORT).show();
        } else if(value_password.length() == 0 || value_password.isEmpty()){
            Toast.makeText(this,"No pueden haber campos vacios, ingrese una contraseña", Toast.LENGTH_SHORT).show();
        } else {
            UserLogin user = new UserLogin(value_email, value_password);
            //
            if(UserListLogin.validateUserLogin(user)){
                Toast.makeText(this,"Se inicio sesion exitosamente :)", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }  else{
                Toast.makeText(this, "Los datos ingresados no existen, registre un nuevo usuario", Toast.LENGTH_SHORT).show();
            }
        }
    }
}