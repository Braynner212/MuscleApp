package com.example.muscleapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button btnSignIn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.editUser);
        password=findViewById(R.id.editPassword);
        btnSignIn=findViewById(R.id.btnLogin);

        email.getText().toString();
        password.getText().toString();
        firebaseAuth = FirebaseAuth.getInstance();

    }
    public void Login(View view) {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        if (Email.isEmpty() || Password.isEmpty()) {

            //Toast.makeText(MainActivity.this, R.string.empty, Toast.LENGTH_SHORT).show();
            email.setError("Empty field"/*,getResources().getDrawable(R.drawable.ic_logout)*/);
            password.setError("Empty field"/*,getResources().getDrawable(R.drawable.ic_logout)*/);
            //showAlerter(This);

        } else {
            firebaseAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Log.e("logged", "onComplete: " + task.isSuccessful());
                            if (task.isSuccessful()) {
                                /**/Intent intent = new Intent(MainActivity.this, UserProfile.class);
                                startActivity(intent);
                            } else {
                                Toast toast = Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG);
                                toast.show();

                            }
                        }
                    });
        }
    }
}
