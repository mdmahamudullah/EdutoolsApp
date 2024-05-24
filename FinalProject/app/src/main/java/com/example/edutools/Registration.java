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

public class Registration extends AppCompatActivity {
    // create object of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://edutools-459f7-default-rtdb.firebaseio.com/");

    EditText fullNameEditText,emailEditText,phoneEditText,passwordEditText,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fullNameEditText=findViewById(R.id.UserNameTextID);
        emailEditText=findViewById(R.id.EmailSignupEdittextID);
        phoneEditText=findViewById(R.id.phoneSignupEdittextID);
        passwordEditText=findViewById(R.id.PasswordSingUpEditTextID);
        confirmPassword=findViewById(R.id.ConPasswordSingUpEditTextID);

    }

    public void BackToLogInPage(View view) {
        Intent myIntent = new Intent(this,Login.class);
        startActivity(myIntent);
    }

    public void SingUPForNewUser(View view) {

        String fullName=fullNameEditText.getText().toString();
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        String conpassword=confirmPassword.getText().toString();
        String phone=phoneEditText.getText().toString();

        //Check
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || conpassword.isEmpty()){

            Toast.makeText(this,"Please Fill all filed",Toast.LENGTH_LONG).show();
        }
        else if (!password.equals(conpassword)){
            Toast.makeText(this,"Password are not match ",Toast.LENGTH_LONG).show();
        }

        else{
            databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // check if phone is not registered

                    if (snapshot.hasChild(phone)){
                        Toast.makeText(Registration.this,"Email is already registered.",Toast.LENGTH_LONG).show();
                    }
                    else {
                        // sending data to firebase Realtime Database.
                        // we are using email  as unique identity of every user.
                        // so all the other details of user comes under phone number

                        databaseReference.child("user").child(phone).child("Full Name").setValue(fullName);
                        databaseReference.child("user").child(phone).child("Email").setValue(email);
                        databaseReference.child("user").child(phone).child("Password").setValue(password);
//                        databaseReference.child("user").child(phone).child("Phone").setValue(phone);

                        // show a success message then finish the activity
                        Toast.makeText(Registration.this,"User registered successfully.",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }

    }
}