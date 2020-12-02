package com.example.temp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestore;

public class Create_Profile extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseFirestore fdb;

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
            String str_email = email.getEditText().getText().toString();
            String str_contactDetails = contactDetails.getEditText().getText().toString();
            String str_password = password.getEditText().getText().toString();
            PlayerData playerData = new PlayerData(str_email, str_contactDetails, str_password);

            fdb = FirebaseFirestore.getInstance();
            fdb.collection("Player_Profile").add(playerData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("Success", "Document ID: " + documentReference.getId());
                }
            });

//            firebaseDatabase = FirebaseDatabase.getInstance();
//            reference = firebaseDatabase.getReference("Players");

//            reference.setValue(playerData);
            startActivity(new Intent(this, Login_Page.class));
            this.finish();
        }
    }
}
