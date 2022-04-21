package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       final EditText edt1=findViewById(R.id.name);
       final EditText edt2=findViewById(R.id.number);
       DBProfile db= new DBProfile();
       final EditText edt3=findViewById(R.id.date);
       final EditText edt4=findViewById(R.id.address);
        Button  btn1=findViewById(R.id.submit);
        btn1.setOnClickListener(view -> {
           ProfileC pro=new ProfileC(edt1.getText().toString(),edt2.getText().length(),edt3.getText().toString(),edt4.getText().toString());
           db.add(pro).addOnSuccessListener(suc->{
               Toast.makeText(profile.this, "Register Successfully", Toast.LENGTH_SHORT).show();
               edt1.setText("");
               edt2.setText("");
               edt3.setText("");
               edt4.setText("");

           }).addOnFailureListener(er->{
               Toast.makeText(profile.this, "Register Failed", Toast.LENGTH_SHORT).show();
           });
        });
    }
}