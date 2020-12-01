package com.example.temp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Page extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button btnNewPlayer = findViewById(R.id.btnNewPlayer);
        btnNewPlayer.setOnClickListener(this);
        Button btnLogin = findViewById(R.id.btnGo);
        btnLogin.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if(((Button) v).getText().toString().equals("Login"))
        {
            // --! Add firebase auth for login
            startActivity(new Intent(this, SinglePlayer.class));
            this.finish();
        }
        else
        {
            startActivity(new Intent(this, Create_Profile.class));
            this.finish();
        }
    }
}