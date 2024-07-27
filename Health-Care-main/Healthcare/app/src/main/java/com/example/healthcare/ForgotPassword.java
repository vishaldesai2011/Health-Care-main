package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText txtemail;
    private String email_str;
    FirebaseAuth autha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        txtemail = (EditText)findViewById(R.id.forgot_email);


    }
    public void forgotPASS(View view){
        txtemail = (EditText)findViewById(R.id.forgot_email);
        email_str = txtemail.getText().toString();
        if(email_str.isEmpty()){
            txtemail.setError("Required");
        }
        else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email_str).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                        if (launchIntent != null) {
                            Toast.makeText(ForgotPassword.this, "Please Wait....", Toast.LENGTH_SHORT).show();
                            startActivity(launchIntent);
                        } else {
                            Toast.makeText(ForgotPassword.this, "Link Successfully send on Your email", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else {
                        AlertDialog alertDialog = new AlertDialog.Builder(ForgotPassword.this).create();
                        alertDialog.setTitle("Forgot Password");
                        alertDialog.setMessage("Email is Wrong !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        Toast.makeText(ForgotPassword.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void back(View view){
        Intent inte = new Intent(ForgotPassword.this,LoginActivity.class);
        startActivity(inte);
    }


}