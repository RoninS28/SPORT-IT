package com.example.temp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestore;

public class Create_Profile extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseFirestore fdb;
    FirebaseAuth auth;

    TextInputLayout contactDetails, email, password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);

        contactDetails = findViewById(R.id.playerFour);
        email = findViewById(R.id.playerThree);
        password = findViewById(R.id.membersNo);

        Button btnBegin = findViewById(R.id.btnBegin);
        btnBegin.setOnClickListener(this);

        Button btnLogin = findViewById(R.id.btnLogin2);
        btnLogin.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        if(((Button) v).getText().toString().equals("Login?"))
        {
            startActivity(new Intent(this, Login_Page.class));
            this.finish();
        }
        else
        {
//            boolean flag=false;
            String str_email = email.getEditText().getText().toString();
            String str_contactDetails = contactDetails.getEditText().getText().toString();
            String str_password = password.getEditText().getText().toString();
            PlayerData playerData = new PlayerData(str_email, str_contactDetails, str_password);

            auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(str_email, str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
//                    flag = true;
                        fdb = FirebaseFirestore.getInstance();
            //            fdb.collection("Player_Profile").
                    if(task.isSuccessful()){
                        fdb.collection("Player_Profile").document(auth.getCurrentUser().getUid()).set(playerData).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("SUCCESS", "USER ADDED");
                            }
                        });


                    }

                }
            });
//            if(flag == true){

//            }



//            firebaseDatabase = FirebaseDatabase.getInstance();
//            reference = firebaseDatabase.getReference("Players");

//            reference.setValue(playerData);

        }
    }
}
