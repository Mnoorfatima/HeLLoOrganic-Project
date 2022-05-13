package com.example.helloorganic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloorganic.Database.OrderContract;
import com.example.helloorganic.Database.OrderHelper;

public class order extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    ImageView imageView;
    ImageButton plusquantity,minusquantity;
    TextView quantitynumber,drinkname,coffeprice;
    CheckBox addTopping,addExtraCream;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues=false;
    OrderHelper orderHelper;

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
        addtoCart=findViewById(R.id.addtocart);
        orderHelper=new OrderHelper(order.this);

        drinkname.setText("Mango");
        //
        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveCart();
            }
        });
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

    private boolean SaveCart() {

        // getting the values from our views
        String name = drinkname.getText().toString();
        String price = coffeprice.getText().toString();
        String quantity = quantitynumber.getText().toString();
        Boolean insert=orderHelper.Insert(name,quantity,price);
        Toast.makeText(order.this, "Order Place Successfully", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(order.this,showorder.class);
        intent.putExtra("name","Name "+"  "+name);
        intent.putExtra("price","Price "+"  " +price);
        intent.putExtra("quantity","Quantity "+"  "+quantity+"kg");

        startActivity(intent);
        //Toast.makeText(this, name+" "+price+""+quantity, Toast.LENGTH_SHORT).show();
      /*  ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (addExtraCream.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_BASKET, "Has Cream: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_BASKET, "Has Cream: NO");

        }

        if (addTopping.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_BAG, "Has Toppings: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_BAG, "Has Toppings: NO");

        }

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }
*/
        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox addExtraCream, CheckBox addTopping) {
        int basePrice=150;
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

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] project={
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
              //  OrderContract.OrderEntry.COLUMN_BAG,
                //OrderContract.OrderEntry.COLUMN_BASKET

        };
        return new CursorLoader(this,mCurrentCartUri,project,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
           // int hasCream = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_BAG);
           // int hasTopping = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_BASKET);


            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);
          //  String yeshasCream = cursor.getString(hasCream);
           // String yeshastopping = cursor.getString(hasTopping);

            drinkname.setText(nameofdrink);
            coffeprice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
        }


    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}