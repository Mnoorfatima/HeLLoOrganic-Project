package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class vist_us extends AppCompatActivity {
ViewFlipper flipper;
EditText edt1;
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vist_us);
        edt1=findViewById(R.id.m1);
        btn1=findViewById(R.id.submit);
        DBmessage Db=new DBmessage();
        btn1.setOnClickListener(view -> {
            message msg=new message(edt1.getText().toString());
            Db.add(msg).addOnSuccessListener(v->{
                Toast.makeText(vist_us.this, "Thanks for Feedback", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
       flipper=findViewById(R.id.viewflipper);
       int imagearray[]={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4};
        for (int i = 0; i<4 ; i++)
        {
            showimage(imagearray[i]);
        }

    }
    public void showimage(int img)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}