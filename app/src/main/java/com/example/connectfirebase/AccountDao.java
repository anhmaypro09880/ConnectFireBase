package com.example.connectfirebase;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountDao {
    private DatabaseReference databaseReference;

    public AccountDao() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference= database.getReference(Account.class.getSimpleName());
    }
    public Task<Void> add(Account acc){
        return databaseReference.push().setValue(acc);
    }
}
