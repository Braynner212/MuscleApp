package com.example.muscleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CreateUser extends AppCompatActivity {
    private EditText name, lastname,email, password, password2;
    private Button btnResgister;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference RootReference , myDta;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);

        name = findViewById(R.id.txtName);
        lastname = findViewById(R.id.txtLastName);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        password2 = findViewById(R.id.txtPassword2);
        btnResgister = findViewById(R.id.btnRegister);

        firebaseAuth = FirebaseAuth.getInstance();
        RootReference = FirebaseDatabase.getInstance().getReference();

        Map<String, Object> UserData = new HashMap<>();

        String nameOn, lastnameOn, emailOn, passwordOn, password2On;
        UserData.put("name", nameOn);
        UserData.put("lastname", lastnameOn);
        UserData.put("email", emailOn);
        UserData.put("password", passwordOn);
        UserData.put("password2", password2On);
        RootReference.child("User").push().setValue(UserData);



    }
}
