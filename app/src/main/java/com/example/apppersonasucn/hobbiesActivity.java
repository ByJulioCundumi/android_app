package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

public class hobbiesActivity extends AppCompatActivity {

    private User actualUser;
    private int position;
    private CheckBox cook, exercise, eat, walk, dance, study, read, sleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        //
        cook = (CheckBox) findViewById(R.id.hobbiesCookId);
        exercise = (CheckBox) findViewById(R.id.hobbiesExerciceId);
        eat = (CheckBox) findViewById(R.id.hobbiesEatId);
        walk = (CheckBox) findViewById(R.id.hobbiesWalkId);
        dance = (CheckBox) findViewById(R.id.hobbiesDanceId);
        study = (CheckBox) findViewById(R.id.hobbiesStudyId);
        read = (CheckBox) findViewById(R.id.hobbiesReadId);
        sleep = (CheckBox) findViewById(R.id.hobbiesSleepId);
        //
        Intent dataIntent = getIntent();
        if (dataIntent.hasExtra("userData")) {
            this.actualUser = (User) dataIntent.getSerializableExtra("userData");
            this.position = (int) dataIntent.getSerializableExtra("position");
        }
        else {
            Toast.makeText(this, "Hubo un error y no llegaron los datos :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveHobbies(View view){

        if(cook.isChecked()){
            actualUser.addHobby("Cocinar");
        }
        if(exercise.isChecked()){
            actualUser.addHobby("Ejercicio");
        }
        if(eat.isChecked()){
            actualUser.addHobby("Comer");
        }
        if(walk.isChecked()){
            actualUser.addHobby("Caminar");
        }
        if(dance.isChecked()){
            actualUser.addHobby("Bailar");
        }
        if(study.isChecked()){
            actualUser.addHobby("Estudiar");
        }
        if(read.isChecked()){
            actualUser.addHobby("Leer");
        }
        if(sleep.isChecked()){
            actualUser.addHobby("Dormir");
        }
        //
        UserList.updateUser(this.position, actualUser);
        //
        Toast.makeText(this, "Se actualizaron los hobbies :)", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void hobbiesToMain(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}