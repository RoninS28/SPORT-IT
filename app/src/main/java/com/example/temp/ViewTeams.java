package com.example.temp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class ViewTeams extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teams);

         Button viewTeam = findViewById(R.id.btnViewTeam);
         viewTeam.setOnClickListener(this::onClick);
        }

    @Override
    public void onClick(View v) {
        if(((Button) v).getText().toString().equals("View Team"))
        {
            startActivity(new Intent(this, SinglePlayer.class));
        }
    }
}
