package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Firebase Instance
        mAuth = FirebaseAuth.getInstance();

    }
    public void logins(View view){
        EditText uname = (EditText)findViewById(R.id.uname);
        EditText pass = (EditText) findViewById(R.id.pass);
        if(uname.getText().toString().isEmpty() && pass.getText().toString().isEmpty()){
            uname.setError("Required !!");
            pass.setError("Required !!");
        }
        else {
            loginUserAccount();
        }
    }
    public void reg(View view){
        Intent inte = new Intent(this,RegistrationActivity.class);
        startActivity(inte);
    }
    private void loginUserAccount(){
        EditText uname = (EditText)findViewById(R.id.uname);
        EditText pass = (EditText) findViewById(R.id.pass);
        String email, password;
        email = uname.getText().toString();
        password = pass.getText().toString();
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplicationContext(),"Please enter email!!",Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getApplicationContext(),"Please enter password!!",Toast.LENGTH_LONG).show();
//            return;
//        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Successs", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void forgot(View view){
        Intent forg = new Intent(this,ForgotPassword.class);
        startActivity(forg);
    }
}

