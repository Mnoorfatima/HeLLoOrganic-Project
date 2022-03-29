package com.example.helloorganic;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBmessage {
    private DatabaseReference databaseReference;
    public DBmessage(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(message.class.getSimpleName());
    }
    public Task<Void> add (message msg){
       return databaseReference.push().setValue(msg);
    }
}
