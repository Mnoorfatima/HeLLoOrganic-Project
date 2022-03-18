package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class vist_us extends AppCompatActivity {
ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vist_us);
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