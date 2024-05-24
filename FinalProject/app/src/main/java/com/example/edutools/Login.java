package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://edutools-459f7-default-rtdb.firebaseio.com/");

    EditText PhoneEdittext,passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        PhoneEdittext=findViewById(R.id.EmailEdittextID);
        passwordEditText=findViewById(R.id.PasswordEditTextID);

    }

    public void LogintoPersonalNote(View view) {
        String Phone=PhoneEdittext.getText().toString();
        String password=passwordEditText.getText().toString();

        if (Phone.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please Enter your Mobile Number or Password",Toast.LENGTH_LONG).show();

        }
        else {
            databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // check if mobile/phone is exist in firebase database

                    if (snapshot.hasChild(Phone)){
                        // mobile is exist in firebase database
                        // now get password of user from firebase data and match it with use entered password

                        final String getPassword = snapshot.child(Phone).child("Password").getValue(String.class);

                        if (getPassword.equals(password)){
                            Toast.makeText(Login.this,"Successfully Logged In",Toast.LENGTH_LONG).show();

                            // open MainActivity on success
                            startActivity(new Intent(Login.this,MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(Login.this,"Wrong Password",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(Login.this,"Wrong Mobile Number",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    public void SingUPAccountFunction(View view) {
        Intent myIntent = new Intent(this,Registration.class);
        startActivity(myIntent);
    }
}