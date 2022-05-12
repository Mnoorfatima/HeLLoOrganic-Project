package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showorder extends AppCompatActivity {
    TextView txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showorder);
        txt1=findViewById(R.id.txt1);
         txt2=findViewById(R.id.txt2);
         txt3=findViewById(R.id.txt3);
        String s1,s2,s3;
        s1=getIntent().getStringExtra("name");
        txt1.setText(s1);
        s2=getIntent().getStringExtra("price");
        txt2.setText(s2);
        s3=getIntent().getStringExtra("quantity");
        txt3.setText(s3);
    }
}