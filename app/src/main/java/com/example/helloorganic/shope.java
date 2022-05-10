package com.example.helloorganic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class shope extends AppCompatActivity {
ArrayList<ContactModel>arrContact=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shope);
        RecyclerView recyclerView=findViewById(R.id.recylearview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  ContactModel model =new ContactModel(R.drawable.f2,"Apple","Rs 100 perk/g");
        arrContact.add(new ContactModel(R.drawable.mango,"mango","Rs200perk/g"));
        arrContact.add(new ContactModel(R.drawable.apple2,"Apple","Rs100perk/g"));
        arrContact.add(new ContactModel(R.drawable.bana,"Banana","Rs300perk/g"));
        arrContact.add(new ContactModel(R.drawable.download,"Graps","Rs300perk/g"));
        arrContact.add(new ContactModel(R.drawable.orange,"Orange","Rs230perk/g"));
        arrContact.add(new ContactModel(R.drawable.carrots,"Carrot","Rs300perk/g"));

        RecylearAdapter adapter=new RecylearAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}