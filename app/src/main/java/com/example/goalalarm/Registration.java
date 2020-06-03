package com.example.goalalarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    private EditText uname;
    private EditText pass;
    private EditText re_pass;
    private FirebaseAuth mAuth;
    private Button register_btn;
    private FirebaseAuth fAuth;
    private Button login_link;
//    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        uname=findViewById(R.id.login_username_id);
        pass=findViewById(R.id.login_password_id);
        re_pass=findViewById(R.id.signup_re_pwd_id);
        register_btn=findViewById(R.id.login_btn_id);
        fAuth = FirebaseAuth.getInstance();
//        progressBar=findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=uname.getText().toString().trim();
                String pass1 = pass.getText().toString().trim();
                String pass2 = re_pass.getText().toString().trim();

                if (TextUtils.isEmpty(username)){
                    uname.setError("Username cannot be empty !!");
                    return;
                }
                if (TextUtils.isEmpty(pass1)){
                    pass.setError("Password cannot be empty !!");
                    return;
                }
                if (pass1.length()<8){
                    pass.setError("Password length mismatch !!");
                    return;
                }
                if (pass1.equals(pass2)){
                    //register user in the firebase
                    fAuth.createUserWithEmailAndPassword(username,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Registration.this, "User successfully registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(Registration.this, "User registration failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Registration.this, "Password fields mismatch !! Enter Again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        login_link = findViewById(R.id.login_link_txt);
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
    }
}
