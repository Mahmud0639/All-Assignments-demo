package com.manuni.allassignmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.manuni.allassignmentsdemo.databinding.ActivityAllInfoBinding;

public class AllInfoActivity extends AppCompatActivity {

    ActivityAllInfoBinding binding;
    String myNameHere, myEmailHere, myPhoneHere, myPasswordHere,myGenderHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myNameHere = getIntent().getStringExtra("myName");
        myEmailHere = getIntent().getStringExtra("myEmail");
        myPhoneHere = getIntent().getStringExtra("myPhone");
        myPasswordHere = getIntent().getStringExtra("myPassword");
        myGenderHere = getIntent().getStringExtra("myGender");

        binding.name.setText("Your name is : "+myNameHere);
        binding.email.setText("Email: "+myEmailHere);
        binding.phone.setText("Phone: "+myPhoneHere);
        binding.password.setText("Password: "+myPasswordHere);
        binding.gender.setText("Gender: "+myGenderHere);
    }
}