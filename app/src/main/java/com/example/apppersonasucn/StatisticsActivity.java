package com.example.apppersonasucn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

import java.util.List;
import java.util.Objects;

public class StatisticsActivity extends AppCompatActivity {
    private TextView totalCookTextView, totalExerciseTextView, totalEatTextView, totalWalkTextView,
            totalDanceTextView, totalStudyTextView, totalReadTextView, totalSleepTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        //
        totalCookTextView = findViewById(R.id.statisticsCookId);
        totalExerciseTextView = findViewById(R.id.statisticsExerciseId);
        totalEatTextView = findViewById(R.id.statisticsEatId);
        totalWalkTextView = findViewById(R.id.statisticsWalkId);
        totalDanceTextView = findViewById(R.id.statisticsDanceId);
        totalStudyTextView = findViewById(R.id.statisticsStudyId);
        totalReadTextView = findViewById(R.id.statisticsReadId);
        totalSleepTextView = findViewById(R.id.statisticsSleepId);
        //
        int totalCook = countUsersWithHobby("Cocinar");
        int totalExercise = countUsersWithHobby("Ejercicio");
        int totalEat = countUsersWithHobby("Comer");
        int totalWalk = countUsersWithHobby("Caminar");
        int totalDance = countUsersWithHobby("Bailar");
        int totalStudy = countUsersWithHobby("Estudiar");
        int totalRead = countUsersWithHobby("Leer");
        int totalSleep = countUsersWithHobby("Dormir");
        //
        if(totalCook == 0){
            totalCookTextView.setText(totalCook + " " + "Usuarios");
        } else{
            totalCookTextView.setText(String.valueOf(totalCook) + " " + "Usuarios");
        }
        if(totalExercise == 0){
            totalExerciseTextView.setText(totalExercise + " " + "Usuarios");
        } else{
            totalExerciseTextView.setText(String.valueOf(totalExercise) + " " + "Usuarios");
        }
        if(totalEat == 0){
            totalEatTextView.setText(totalEat + " " + "Usuarios");
        } else{
            totalEatTextView.setText(String.valueOf(totalEat) + " " + "Usuarios");
        }
        if(totalWalk == 0){
            totalWalkTextView.setText(totalWalk + " " + "Usuarios");
        } else{
            totalWalkTextView.setText(String.valueOf(totalWalk) + " " + "Usuarios");
        }
        if(totalDance == 0){
            totalDanceTextView.setText(totalDance + " " + "Usuarios");
        } else{
            totalDanceTextView.setText(String.valueOf(totalDance) + " " + "Usuarios");
        }
        if(totalStudy == 0){
            totalStudyTextView.setText(totalStudy + " " + "Usuarios");
        } else{
            totalStudyTextView.setText(String.valueOf(totalStudy) + " " + "Usuarios");
        }
        if(totalRead == 0){
            totalReadTextView.setText(totalRead + " " + "Usuarios");
        } else{
            totalReadTextView.setText(String.valueOf(totalRead) + " " + "Usuarios");
        }
        if(totalSleep == 0){
            totalSleepTextView.setText(totalSleep + " " + "Usuarios");
        } else{
            totalSleepTextView.setText(String.valueOf(totalSleep) + " " + "Usuarios");
        }
    }

    public int countUsersWithHobby(String hobby) {
        int count = 0;
        for (User user : UserList.getUserList()) {
            for(String hobbie : user.getHobbies()){
                if(hobbie.equals(hobby)){
                    count++;
                }
            }
        }
        return count;
    }

    public void statisticsToMain(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}