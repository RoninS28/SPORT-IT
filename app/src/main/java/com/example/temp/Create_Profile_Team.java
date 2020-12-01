package com.example.temp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Profile_Team extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    TextInputLayout teamName, teamHead, membersNo, stadiumName, playertwoName, playerthreeName, playerfourName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile_team);

        teamName = findViewById(R.id.playerFour);
        teamHead = findViewById(R.id.playerThree);
        membersNo = findViewById(R.id.membersNo);
        stadiumName = findViewById(R.id.Stadium);
        playertwoName = findViewById(R.id.PlayertwoName);
        playerthreeName = findViewById(R.id.playerThree);
        playerfourName = findViewById(R.id.playerFour);


        Button btnBegin = findViewById(R.id.btnBegin);
        //btnBegin.setOnClickListener(this);

        Button btnLogin = findViewById(R.id.btnCompleteProfile);
        btnLogin.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        if(((Button) v).getText().toString().equals("Create Team"))
        {
            String str_teamName = teamName.getEditText().getText().toString();
            String str_teamHead = teamHead.getEditText().getText().toString();
            String str_membersNo = membersNo.getEditText().getText().toString();
            String str_playertwo = playertwoName.getEditText().getText().toString();
            String str_playerThree = playerthreeName.getEditText().getText().toString();
            String str_playerFour = playerfourName.getEditText().getText().toString();
            String str_stadiumName = stadiumName.getEditText().getText().toString();

            TeamData playerData = new TeamData(str_teamName, str_teamHead, str_membersNo, str_playertwo, str_playerThree, str_playerFour, str_stadiumName);

            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference("Teams");

            reference.setValue(playerData);
            Toast.makeText(this, "Created profile for Team", Toast.LENGTH_SHORT).show();
        }
        else
        {
            startActivity(new Intent(this, SinglePlayer.class));
        }
    }
}
