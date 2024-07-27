package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText email,pass,cpass;
    Button Register;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        email = findViewById(R.id.add);
        pass = findViewById(R.id.passw);
        cpass = findViewById(R.id.cpass);
        Register =findViewById(R.id.regs);

        mAuth = FirebaseAuth.getInstance();

    }
    public void reg(View view){
        createUser();
    }
    private void createUser(){
        String Email = email.getText().toString();
        String Pass = pass.getText().toString();
        String Cpass = cpass.getText().toString();
        if(TextUtils.isEmpty(Email)){
            email.setError("Email cannot be Empty");
        }
        else if(TextUtils.isEmpty(Pass)){
            pass.setError("Password cannot be Empty");
        }
        else if(TextUtils.isEmpty(Cpass)){
            cpass.setError("Confirm Password cannot be Empty");
        }
        else if(Cpass.equals(Pass) == false){
            pass.setError("Confirm Password And Password Both Are Different");
            pass.requestFocus();
            cpass.setError("Confirm Password And Password Both Are Different");
        }
        else {
            mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this, "You Have Successfully Register", Toast.LENGTH_SHORT).show();
                        ProgressDialog progressBar = new ProgressDialog(RegistrationActivity.this);
                        progressBar.setMessage("Redirecting...");
                        progressBar.show();
                        Intent inte =  new Intent(RegistrationActivity.this,LoginActivity.class);
                        SystemClock.sleep(3000);
                        startActivity(inte);
                        finish();
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Something Wrong please Try Again"+task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}