package com.example.connectfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText edtName,edtEmail,edtPass1,edtPass2;
    Button btnRegister;
    private ProgressBar loadPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    AccountDao accDao = new AccountDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        khaiBao();
    }
    public void khaiBao(){
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmailR);
        edtPass1 = findViewById(R.id.edtPass1);
        edtPass2 = findViewById(R.id.edtPass1);
        btnRegister = findViewById(R.id.btnRegisterR);
        register();
    }
    public void register(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =  edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String pass1 = edtPass1.getText().toString();
                String pass2 = edtPass2.getText().toString();
                Account acc = new Account(name,email,pass1);
                accDao.add(acc).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Register.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this,"Them that bai",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}