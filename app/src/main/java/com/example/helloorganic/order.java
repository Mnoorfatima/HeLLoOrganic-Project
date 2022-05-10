package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity {
    ImageView imageView;
    ImageButton plusquantity,minusquantity;
    TextView quantitynumber,drinkname,coffeprice;
    CheckBox addTopping,addExtraCream;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        imageView=findViewById(R.id.imageViewInfo);
        plusquantity=findViewById(R.id.addquantity);
        minusquantity=findViewById(R.id.subquantity);
        quantitynumber=findViewById(R.id.quantity);
        drinkname=findViewById(R.id.drinkNameinInfo);
        coffeprice=findViewById(R.id.coffeePrice);
        addTopping=findViewById(R.id.addToppings);
        addExtraCream=findViewById(R.id.addCream);

        drinkname.setText("Mango");
        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int baseprice=150;
                quantity++;
                displayquantity();
                int coffePrice=baseprice*quantity;
                String setnewPrice=String.valueOf(coffePrice);
                coffeprice.setText(setnewPrice+"Rs");
                //checkbox Function
                int ifCheckBox=CalculatePrice(addExtraCream,addTopping);
                coffeprice.setText(ifCheckBox+"Rs");

            }
        });
        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity==0){
                    Toast.makeText(order.this, "Cant Decrease quantity < 0", Toast.LENGTH_SHORT).show();
                }else{
                    int baseprice=150;
                    quantity--;
                    displayquantity();
                    int coffePrice=baseprice*quantity;
                    String setnewPrice=String.valueOf(coffePrice);
                    coffeprice.setText(setnewPrice+"Rs");
                       //checkBox
                    int ifCheckBox=CalculatePrice(addExtraCream,addTopping);
                    coffeprice.setText(ifCheckBox+"Rs");
                }
            }
        });
    }

    private int CalculatePrice(CheckBox addExtraCream, CheckBox addTopping) {
        int basePrice=100;
        if (addExtraCream.isChecked()){
            basePrice=basePrice+100;
        }
        if (addTopping.isChecked()){
            basePrice=basePrice+50;
        }
        return basePrice*quantity;
    }

    private void displayquantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }
}