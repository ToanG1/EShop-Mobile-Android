package com.example.eshop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    String sizeChoice = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RangeSlider rangeSlider = findViewById(R.id.my_range_slider);
//        rangeSlider.setValues(1f, 10f);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
    public void select_size_handler(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_dialog_select_size);

        AppCompatButton size1 = dialog.findViewById(R.id.size1);
        AppCompatButton size2 = dialog.findViewById(R.id.size2);
        AppCompatButton size3 = dialog.findViewById(R.id.size3);
        AppCompatButton size4 = dialog.findViewById(R.id.size4);
        AppCompatButton size5 = dialog.findViewById(R.id.size5);
        AppCompatButton size6 = dialog.findViewById(R.id.size6);
        AppCompatButton submitbtn = dialog.findViewById(R.id.submitSize_btn);
        size1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeChoice = "size1";
            }
        });

        size2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeChoice = "size2";
            }
        });

        size3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeChoice = "size3";
            }
        });

        size4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                sizeChoice = "size4";
            }
        });

        size5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeChoice = "size5";
            }
        });

        size6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeChoice = "size6";
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, sizeChoice + " is selected", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setWindowAnimations(R.style.BottomDialogAnimation);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }
}