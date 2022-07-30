package com.manuni.allassignmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.manuni.allassignmentsdemo.databinding.ActivityLoginPageDesignBinding;

public class LoginPageDesign extends AppCompatActivity {
    ActivityLoginPageDesignBinding binding;
    String name, email,phone,password;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageDesignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.editTxt1.getText().toString().trim();
                email = binding.editTxt2.getText().toString().trim();
                phone = binding.editTxt3.getText().toString().trim();
                password = binding.editTxt4.getText().toString().trim();

                int id = binding.radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(id);

                Intent intent = new Intent(LoginPageDesign.this,AllInfoActivity.class);
                intent.putExtra("myName",name);
                intent.putExtra("myEmail",email);
                intent.putExtra("myPhone",phone);
                intent.putExtra("myPassword",password);
                intent.putExtra("myGender",radioButton.getText().toString());
                startActivity(intent);
            }
        });


    }
}