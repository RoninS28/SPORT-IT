package com.example.temp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.api.core.ApiFuture;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class Login_Page extends AppCompatActivity  {
    TextInputLayout iusername, ipassword;
    FirebaseFirestore fdb;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        iusername = findViewById(R.id.username);
        ipassword = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();

        Button btnNewPlayer = findViewById(R.id.btnNewPlayer);
//        btnNewPlayer.setOnClickListener(this);
        Button btnLogin = findViewById(R.id.btnGo);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = iusername.getEditText().getText().toString();
                String password = ipassword.getEditText().getText().toString();
                Log.println(Log.INFO, "ENTERED USERNAME IS" + username, "USERNAME IS " + username);
                Log.println(Log.INFO, "ENTERED PASSWORD IS" + password, "PASSWORD IS " + password);

                auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.println(Log.INFO, "SUCCESS" , "SUCCESS IS " );
//                            startActivity(new Intent(getApplicationContext(), SinglePlayer.class));
//                            finish();
                        }

                    }
                });
            }
        });
    }


//    @Override
//    public void onClick(View v) {
////        if(((Button) v).getText().toString().equals("Login")) {
////            boolean flag = false;
////            String username = iusername.getEditText().getText().toString();
////            String password = ipassword.getEditText().getText().toString();
////            Log.println(Log.INFO, "ENTERED USERNAME IS" + username, "USERNAME IS " + username);
////            Log.println(Log.INFO, "ENTERED PASSWORD IS" + password, "PASSWORD IS " + password);
////            auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
////                @Override
////                public void onComplete(@NonNull Task<AuthResult> task) {
////                    if(task.isSuccessful()){
////                        startActivity(new Intent(getApplicationContext(), SinglePlayer.class));
////                        finish();
////                    }
////
////                }
////            });
////            // --! Add firebase auth for login
////
////
////            }
//
//        if(((Button) v).getText().toString().equals("New Player?"))
//        {
//            startActivity(new Intent(this, Create_Profile.class));
//            this.finish();
//        }
//    }

}