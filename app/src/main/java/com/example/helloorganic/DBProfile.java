package com.example.helloorganic;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBProfile
{
    private DatabaseReference databaseReference;
    public DBProfile()
    {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference= db.getReference(ProfileC.class.getSimpleName());
    }
    public Task<Void> add(ProfileC pro)
    {
       return databaseReference.push().setValue(pro);
    }
}
