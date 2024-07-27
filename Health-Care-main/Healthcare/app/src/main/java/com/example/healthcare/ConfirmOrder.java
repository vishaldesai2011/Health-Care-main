package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setTextColor(Color.parseColor("#FFFFFF"));
        Intent in = getIntent();
        String oid = in.getStringExtra(PaymentPage.id);
        TextView t = (TextView)findViewById(R.id.oid);
        t.setText("Your order  ID \n"+oid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ConfirmOrder.this,Splesh_Activity.class);
                startActivity(home);
                ConfirmOrder.this.finish();
                System.exit(0);
            }
        });


    }


}