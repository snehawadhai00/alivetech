package com.alivetech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ll_vertical);

        Toast.makeText(this, "Hii alive tech", Toast.LENGTH_SHORT).show();
    }


}   