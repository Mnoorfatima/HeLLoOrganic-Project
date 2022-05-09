package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class about_us extends AppCompatActivity {
    TextView textView,ratecount,show;
    RatingBar ratingBar;
    Button btn1;
    float ratevalue;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        textView = findViewById(R.id.r1);
        ratecount=findViewById(R.id.ratecount);
        ratingBar = findViewById(R.id.r2);
        btn1=findViewById(R.id.btn1);
        show=findViewById(R.id.showrating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratevalue=ratingBar.getRating();
                if(ratevalue<=1 && ratevalue>0)
                    ratecount.setText("Bad" + ratevalue+"/5");
                else if(ratevalue<=2 && ratevalue>1)
                    ratecount.setText("Ok" + ratevalue+"/5");
                else if(ratevalue<=3 && ratevalue>2)
                    ratecount.setText("Good" + ratevalue+"/5");
                else if(ratevalue<=4 && ratevalue>3)
                    ratecount.setText("Very Good" + ratevalue+"/5");
                else if(ratevalue<=5 && ratevalue>4)
                    ratecount.setText("Best" + ratevalue+"/5");
                textView.setText("Rate"+ v);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp =ratecount.getText().toString();
                show.setText("Your Rating\n"+" " + ""+temp);
                ratingBar.setRating(0);

            }
        });
    }
}