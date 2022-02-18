package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginSignin extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signin);
        btn1=findViewById(R.id.btnlogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btn1.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relative,new signin_page()).commit();
            }
        });
        btn2=findViewById(R.id.btnsigin);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btn2.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.relative,new login_fragment()).commit();
            }
        });
    }
}