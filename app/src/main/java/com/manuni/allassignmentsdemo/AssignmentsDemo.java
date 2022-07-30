package com.manuni.allassignmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AssignmentsDemo extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView, showTxt,subjectTxt;
    private CheckBox checkBox1, checkBox2,checkBox3,checkBox4;
    private ToggleButton btn;
    private Spinner spinner;
    private String spinnerItem;
    private Button submitBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments_demo);

        getSupportActionBar().hide();

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.showlangText);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        showTxt = findViewById(R.id.textView);
        spinner = findViewById(R.id.mySpinner);
        subjectTxt = findViewById(R.id.subjectTxt);

        btn = findViewById(R.id.btnLang);
        submitBtn = findViewById(R.id.submitBtn);

        showTxt.setText("Volume "+seekBar.getProgress()+"/"+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                showTxt.setText("Volume : "+i+" / "+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AssignmentsDemo.this, "Your touch point at "+seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AssignmentsDemo.this, "You have to reach "+seekBar.getMax(), Toast.LENGTH_SHORT).show();
            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox1.isChecked()){
                    checkBox1.setTextColor(getResources().getColor(R.color.purple_200));

                }else {
                    checkBox1.setTextColor(getResources().getColor(R.color.black));
                }

            }

        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn.isChecked()){

                    btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_green_bg));
                    String names = "";
                    if (checkBox1.isChecked()){
                        names += "C";

                    }
                    if (checkBox2.isChecked()){
                        names +="\nC++";
                    }
                    if (checkBox3.isChecked()){
                        names +="\nJava";
                    }
                    if (checkBox4.isChecked()){
                        names +="\nPython";
                    }
                    textView.setText(names);
                }else {

                    btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_drawable));
                }
            }
        });

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.spinner_value, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinnerItem.equals("-Select a category-")){
                    Toast.makeText(AssignmentsDemo.this, "Select category", Toast.LENGTH_SHORT).show();
                    subjectTxt.setText("");
                }else {
                    subjectTxt.setText(spinnerItem);
                }
            }
        });
    }
}