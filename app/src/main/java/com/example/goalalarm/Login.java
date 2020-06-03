package com.example.goalalarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login_btn;
    private Button sign_in_link;
//    private ProgressBar progressBar;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.login_username_id);
        password=findViewById(R.id.login_password_id);
        login_btn=findViewById(R.id.login_btn_id);
        fAuth=FirebaseAuth.getInstance();
        sign_in_link=findViewById(R.id.register_id);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (TextUtils.isEmpty(uname)){
                    username.setError("Username cannot be empty !!");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    password.setError("Password cannot be empty !!");
                    return;
                }
                if (pass.length()<8){
                    password.setError("Password length mismatch !!");
                    return;
                }

//                progressBar.setVisibility(View.VISIBLE);
                //Authenticate users
                fAuth.signInWithEmailAndPassword(uname,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "User login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(Login.this, "Error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        sign_in_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();
            }
        });
    }
}
